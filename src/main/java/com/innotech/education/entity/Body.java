package com.innotech.education.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "body_table")
public class Body {

    @Id
    private long id;

    private int price;
    private int isBought;
    String bodyPicture;

}
