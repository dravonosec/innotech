package com.innotech.education.repository;

import com.innotech.education.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterByUsername(String username);
}
