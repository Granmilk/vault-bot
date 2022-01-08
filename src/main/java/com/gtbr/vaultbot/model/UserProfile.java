package com.gtbr.vaultbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserProfile {

    @Id
    @Column
    private String discordId;

    @Column
    private String name;

    @Column
    private String discordTag;

    @Column
    private String registeredAt;

    @Column
    private String generalPassword;
}
