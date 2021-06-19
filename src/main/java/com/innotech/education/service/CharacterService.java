package com.innotech.education.service;

import com.innotech.education.entity.Character;
import com.innotech.education.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public Character getCharacter(String username){return characterRepository.getCharacterByUsername(username);}
}
