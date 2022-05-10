package com.mcj.core.domain.user;

import com.mcj.core.domain.user.User;
import com.mcj.core.domain.user.UserRole;
import com.mcj.core.embed.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void 유저_엔티티_생성_성공() {
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        final User user = new User("id", "pss", "email", "nickname", address, now, UserRole.USER);

        assertThat(user.getTextId()).isEqualTo("id");
        assertThat(user.getPassword()).isEqualTo("pss");
        assertThat(user.getEmail()).isEqualTo("email");
        assertThat(user.getNickName()).isEqualTo("nickname");
        assertThat(user.getAddress()).isNotNull();
        assertThat(user.getBirthday()).isNotNull();
        assertThat(user.getRole()).isEqualTo(UserRole.USER);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 유저_아이디가_없으면_생성_실패(String name) {
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        assertThatIllegalArgumentException().isThrownBy(() -> new User(name, "pss", "email", "nickname", address, now, UserRole.USER));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 유저_이메일이_없으면_생성_실패(String email) {
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        assertThatIllegalArgumentException().isThrownBy(() -> new User("user", "password", email, "nickname", address, now, UserRole.USER));
    }

    @Test
    void 유저_주소가_없으면_생성_실패() {
        final OffsetDateTime now = OffsetDateTime.now();
        assertThatNullPointerException().isThrownBy(() -> new User("user", "password", "email", "nickname", null, now, UserRole.USER));
    }

    @Test
    void 유저_생일이_없으면_생성_실패() {
        final Address address = new Address("A", "b", "c");
        assertThatNullPointerException().isThrownBy(() -> new User("user", "password", "email", "nickname", address, null, UserRole.USER));
    }

    @Test
    void 유저_권한이_없으면_생성_실패() {
        final Address address = new Address("A", "b", "c");
        final OffsetDateTime now = OffsetDateTime.now();
        assertThatNullPointerException().isThrownBy(() -> new User("user", "password", "email", "nickname", address, now, null));
    }

}