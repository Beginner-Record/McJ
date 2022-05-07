package com.record.mcj.domain.resume;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EducationTest {

    @Test
    void 교육_생성_성공() {
        final Education education = new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), "재학", "0", "4.5", "컴퓨터공학과", false);

        assertThat(education.getSchoolDivision()).isEqualTo("대학교(4년)");
        assertThat(education.getSchoolName()).isEqualTo("하버드대학교");
        assertThat(education.getAdmissionDate()).isNotNull();
        assertThat(education.getGraduationDate()).isNotNull();
        assertThat(education.getGraduationState()).isEqualTo("재학");
        assertThat(education.getTotalGrades()).isEqualTo("0");
        assertThat(education.getMaxGrades()).isEqualTo("4.5");
        assertThat(education.getMajorName()).isEqualTo("컴퓨터공학과");
        assertThat(education.isTransferred()).isEqualTo(false);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_학교구분이_없으면_생성_실패(String schoolDivision) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education(schoolDivision, "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), "재학", "0", "4.5", "컴퓨터공학과", false));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_학교이름이_없으면_생성_실패(String schoolName) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education("대학교(4년)", schoolName, OffsetDateTime.now(), OffsetDateTime.now(), "재학", "0", "4.5", "컴퓨터공학과", false));
    }

    @Test
    void 교육_입학년월이_없으면_생성_실패() {
        assertThatNullPointerException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", null, OffsetDateTime.now(), "재학", "0", "4.5", "컴퓨터공학과", false));
    }

    @Test
    void 교육_졸업년월이_없으면_생성_실패() {
        assertThatNullPointerException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), null, "재학", "0", "4.5", "컴퓨터공학과", false));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_졸업상태가_없으면_생성_실패(String graduationState) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), graduationState, "0", "4.5", "컴퓨터공학과", false));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_학점이_없으면_생성_실패(String totalGrades) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), "재학", totalGrades, "4.5", "컴퓨터공학과", false));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_총점이_없으면_생성_실패(String maxGrades) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), "재학", "0", maxGrades, "컴퓨터공학과", false));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 교육_전공이_없으면_생성_실패(String majorName) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Education("대학교(4년)", "하버드대학교", OffsetDateTime.now(), OffsetDateTime.now(), "재학", "0", "4.5", majorName, false));
    }

}
