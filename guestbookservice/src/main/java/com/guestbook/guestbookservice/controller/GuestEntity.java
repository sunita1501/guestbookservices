package com.guestbook.guestbookservice.controller;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String name;
    String comment;

    public GuestEntity (String name, String comment){
        this.name = name;
        this.comment=comment;
    }


}
