package com.gtbr.vaultbot.repository;

import com.gtbr.vaultbot.model.Guild;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends CrudRepository<Guild, String> {
}
