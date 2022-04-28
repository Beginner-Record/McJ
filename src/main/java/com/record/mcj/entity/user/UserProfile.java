package com.record.mcj.entity.user;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfile {

    @Id
    @GeneratedValue
    @Column(name = "user_profile_id")
    private Long id;

    private String job;

    private String introduce;

    private String picture;

    @OneToOne(mappedBy = "userProfile")
    private User user;

    @OneToMany(mappedBy = "userProfile")
    private List<UserCareer> userCareers = new ArrayList<>();

    @OneToMany(mappedBy = "userProfile")
    private List<UserEducation> userEducations = new ArrayList<>();


}
