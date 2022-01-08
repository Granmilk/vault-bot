package com.gtbr.vaultbot.repository;

import com.gtbr.vaultbot.model.PrivateChannel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateChannelRepository extends CrudRepository<PrivateChannel, String> {
}
