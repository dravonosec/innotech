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
@Table(name = "legs_table")
public class Legs {

    @Id
    private long id;

    @OneToOne
    private Character character;
    private String name;
    private int price;
    private int isBought;
    String legsPicture;
}
