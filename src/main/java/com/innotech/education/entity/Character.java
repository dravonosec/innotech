package com.innotech.education.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Character_table")
public class Character {

    @Id
    private long id;

    @OneToOne
    private Body body;
    @OneToOne
    private Head head;
    @OneToOne
    private Legs legs;
    @OneToOne
    private User username;

    private int score;
    private int experience;
    private int level;

}
