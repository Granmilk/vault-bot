package com.gtbr.vaultbot.repository;

import com.gtbr.vaultbot.model.PrivateChannel;
import com.gtbr.vaultbot.model.UserGuild;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateChannelRepository extends CrudRepository<PrivateChannel, String> {
}
