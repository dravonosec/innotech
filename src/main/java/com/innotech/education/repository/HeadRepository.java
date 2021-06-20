package com.innotech.education.repository;

import com.innotech.education.entity.Character;
import com.innotech.education.entity.Head;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeadRepository extends JpaRepository<Head, Long> {
    public List<Head> getHeadsByCharacterId(Long id);
}
