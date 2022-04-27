package com.record.mcj.entity;

import javax.persistence.*;

@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name ="board_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;


}
