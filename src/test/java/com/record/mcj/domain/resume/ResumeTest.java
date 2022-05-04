package com.record.mcj.domain.resume;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResumeTest {

    @Test
    void 이력서_생성_성공() {
        final Resume resume = new Resume("제목", "인천!서울", "개발자!웹개발자");

        assertThat(resume.getTitle()).isEqualTo("제목");
        assertThat(resume.getDesiredLocations()).isEqualTo("인천!서울");
        assertThat(resume.getDesiredWorks()).isEqualTo("개발자!웹개발자");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이력서_제목이_없으면_생성_실패(String title) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Resume(title, "인천!서울", "개발자!웹개발자"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이력서_원하는_장소가_없으면_생성_실패(String desiredLocation) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Resume("title", desiredLocation, "개발자!웹개발자"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이력서_원하는_직군이_없으면_생성_실패(String desiredWork) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Resume("title", "인천!서울", desiredWork));
    }

}