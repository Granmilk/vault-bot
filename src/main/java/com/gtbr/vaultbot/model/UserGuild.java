package com.gtbr.vaultbot.model;

import com.gtbr.vaultbot.model.enums.Status;
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

    @Column
    private Boolean isAdmin;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "guild_Id")
    private Guild guild;

    @OneToOne
    @JoinColumn(name = "discord_id")
    private UserProfile userProfile;
}
