package com.record.mcj.entity;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    @Embedded
    private Address address;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    public User(Long id, String name, String email, String password, Address address, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
    }
}
