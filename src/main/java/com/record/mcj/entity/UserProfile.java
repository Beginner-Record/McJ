package com.record.mcj.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class UserProfile {

    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    private String job;

    private String introduce;

    private String picture;



}
