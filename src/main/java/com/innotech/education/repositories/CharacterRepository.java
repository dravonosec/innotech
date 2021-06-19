package com.innotech.education.repositories;

import com.innotech.education.models.Body;
import com.innotech.education.models.Character;
import com.innotech.education.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterByUsername(String username);
}
