package com.gtbr.vaultbot.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConfigVariables {

    @Value("${spring.datasource.url}")
    private String dataBaseUrl;

    @Value("${spring.datasource.username}")
    private String dataBaseUser;

    @Value("${spring.datasource.password}")
    private String dataBasePassword;

    @Value("${discord.token}")
    private String discordToken;
}
