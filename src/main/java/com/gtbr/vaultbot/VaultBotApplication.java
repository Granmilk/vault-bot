package com.gtbr.vaultbot;

import com.gtbr.vaultbot.config.ConfigVariables;
import com.gtbr.vaultbot.listener.MessageListener;
import com.gtbr.vaultbot.utils.SpringContext;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class VaultBotApplication {

    private static JDA jda;


    public static void main(String[] args) throws LoginException {
        SpringApplication.run(VaultBotApplication.class, args);

        ConfigVariables configVariables = SpringContext.getBean(ConfigVariables.class);
        Flyway flyway = Flyway.configure().dataSource(configVariables.getDataBaseUrl(), configVariables.getDataBaseUser(), configVariables.getDataBasePassword()).load();
        if (configVariables.isMigrate())
            flyway.migrate();

        jda = JDABuilder.createDefault(configVariables.getDiscordToken())
                .addEventListeners(new MessageListener())
                .build();
    }

    public static JDA getJda() {
        return jda;
    }

}
