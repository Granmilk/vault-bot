package com.gtbr.vaultbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGuild {

    @Id
    @Column
    private String userGuildId;

    @OneToOne
    @JoinColumn(name = "guild_Id")
    private Guild guildId;

    @OneToOne
    @JoinColumn(name = "discord_id")
    private UserProfile discordId;
}
