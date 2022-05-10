package com.mcj.core.resume.domain;

import com.mcj.core.career.domain.Career;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue
    @Column(name = "resume_id")
    private Long id;

    /* 제목 */
    private String title;

    /* 원하는 위치 */
    private String  desiredLocations;

    /* 원하는 직군 */
    private String desiredWorks;

    private OffsetDateTime createAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "resume")
    private List<Career> careers = new ArrayList<>();


    public Resume(String title, String desiredLocations, String desiredWorks) {
        checkArgument(Strings.isNotBlank(title), "제목이 없으면 생성 불가 ");
        checkArgument(Strings.isNotBlank(desiredLocations), "제목이 없으면 생성 불가 ");
        checkArgument(Strings.isNotBlank(desiredWorks), "제목이 없으면 생성 불가 ");

        this.title = title;
        this.desiredLocations = desiredLocations;
        this.desiredWorks = desiredWorks;
    }

}
