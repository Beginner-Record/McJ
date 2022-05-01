package com.record.mcj.domain.user;

import com.record.mcj.data.Address;
import com.record.mcj.data.Role;
import com.record.mcj.domain.board.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private final LocalDateTime joinDate = LocalDateTime.now();

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_prifle_id")
    private UserProfile userProfile;

    public User(String name, String email, String password, Address address, LocalDateTime birthday, Role role) {
        checkArgument(Strings.isNotBlank(name), "사용자 이름은 필수입니다.");
        checkArgument(Strings.isNotBlank(email), "이메일은 필수입니다.");
        checkArgument(Strings.isNotBlank(password), "패스워드는 필수입니다.");
        checkArgument(birthday != null, "생년월일은 필수입니다.");

        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.role = role;
    }
}
