package com.record.mcj.domain.resume;

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
public class Education {

    @Id
    @GeneratedValue
    @Column(name = "education_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    /* 학교 구분 */
    private String schoolDivision;

    /* 학교 이름 */
    private String schoolName;

    /* 입학년월 */
    private OffsetDateTime admissionDate;

    /* 졸업년월 */
    private OffsetDateTime graduationDate;

    /* 졸업 상태 */
    private String graduationState;

    /* 학점 */
    private String totalGrades;

    /* 총점 */
    private String maxGrades;

    /* 전공명 */
    private String majorName;

    /* 편입여부 */
    private boolean transferred;


    public Education(String schoolDivision, String schoolName, OffsetDateTime admissionDate, OffsetDateTime graduationDate, String graduationState, String totalGrades, String maxGrades, String majorName, boolean transferred) {
        checkArgument(Strings.isNotBlank(schoolDivision), "학교구분이 없으면 생성불가");
        checkArgument(Strings.isNotBlank(schoolName), "학교명이 없으면 생성불가");
        checkNotNull(admissionDate, "입학년월이 없으면 생성불가");
        checkNotNull(graduationDate, "졸업년월이 없으면 생성불가");
        checkArgument(Strings.isNotBlank(graduationState), "졸업상태가 없으면 생성불가");
        checkArgument(Strings.isNotBlank(totalGrades), "학점이 없으면 생성불가");
        checkArgument(Strings.isNotBlank(maxGrades), "총점이 없으면 생성불가");
        checkArgument(Strings.isNotBlank(majorName), "전공명이 없으면 생성불가");

        this.schoolDivision = schoolDivision;
        this.schoolName = schoolName;
        this.admissionDate = admissionDate;
        this.graduationDate = graduationDate;
        this.graduationState = graduationState;
        this.totalGrades = totalGrades;
        this.maxGrades = maxGrades;
        this.majorName = majorName;
        this.transferred = transferred;
    }

}