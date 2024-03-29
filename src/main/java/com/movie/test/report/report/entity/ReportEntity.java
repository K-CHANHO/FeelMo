package com.movie.test.report.report.entity;

import com.movie.test.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "mv_report")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@DynamicUpdate
public class ReportEntity extends BaseTimeEntity {

    @Id
    @Column
    private String reportId; // 감상문 id

    @Column
    private String title; // 감상문 제목

    @Column
    @Lob
    private String content; // 감상문 내용

    @Column
    private String userId; // 작성자 userId

    @Column
    private String movieId; // 영화ID (TMDB)

    @Column
    private String imageUrl; // 이미지 url

}
