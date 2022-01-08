package com.gtbr.vaultbot.repository;

import com.gtbr.vaultbot.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, String> {
    
}
