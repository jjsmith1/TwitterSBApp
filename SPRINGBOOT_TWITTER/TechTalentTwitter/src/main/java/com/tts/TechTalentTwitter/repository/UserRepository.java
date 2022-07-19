package com.tts.TechTalentTwitter.repository;

import com.tts.TechTalentTwitter.configuration.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    package com.tts.TechTalentTwitter.repository;

    @Repository
    public interface UserRepository extends CrudRepository<User, Long> {
        User findByUsername(String username);
    }
}
