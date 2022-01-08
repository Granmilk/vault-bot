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
public class PrivateChannel {

    @Id
    @Column
    private String privateChannelId;

    @OneToOne
    @JoinColumn(name = "guild_id")
    private Guild guildId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Column
    private String password;
}
