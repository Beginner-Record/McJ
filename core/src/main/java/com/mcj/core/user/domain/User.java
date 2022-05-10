package com.mcj.core.user.domain;

import com.mcj.core.embed.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.OffsetDateTime;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    /* 아이디 */
    private String textId;

    /* 비밀번호 */
    private String password;

    /* 이메일 */
    private String email;

    /* 닉네임 */
    private String nickName;

    /* 주소 */
    private com.mcj.core.embed.Address Address;

    /* 생일 */
    private OffsetDateTime birthday;

    /* 권한 */
    @Enumerated(EnumType.STRING)
    private UserRole role;

    /* 생성날짜 */
    private final OffsetDateTime createAt = OffsetDateTime.now();


    public User(String textId, String password, String email, String nickName, Address address, OffsetDateTime birthday, UserRole role) {
        checkArgument(Strings.isNotBlank(textId), "아이디가 없으면 생성 불가");
        checkArgument(Strings.isNotBlank(password), "비밀번호가 없으면 생성 불가");
        checkArgument(Strings.isNotBlank(email), "이메일이 없으면 생성 불가");
        checkNotNull(address, "주소가 없으면 생성 불가");
        checkNotNull(birthday, "생일이 없으면 생성 불가");
        checkNotNull(role, "권한이 없으면 생성 불가");

        this.textId = textId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.Address = address;
        this.birthday = birthday;
        this.role = role;
    }

}
