package com.innotech.education.services;

import com.innotech.education.models.Character;
import com.innotech.education.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public Character getCharacter(String username){return characterRepository.findCharacterByUsername(username);}
}
