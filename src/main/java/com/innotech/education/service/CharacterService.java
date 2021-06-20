package com.innotech.education.service;

import com.innotech.education.entity.Character;
import com.innotech.education.repository.CharacterRepository;
import com.innotech.education.repository.HeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    HeadRepository headRepository;

    public Character getCharacter(String username){return characterRepository.getCharacterByUsername(username);}

    public Boolean setHead(String username, long id){
        characterRepository.getCharacterByUsername(username).getHead().setId(id);
        return true;
    }
}
