package com.movie.test.complaint.entity;

import com.movie.test.common.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "mv_complaint")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
public class ComplaintEntity extends BaseTimeEntity {

    @Id
    private String complaintId; // 신고 id

    @Column
    private String userId; // 신고한 유저

    @Column
    private String type; // 게시글 또는 댓글

    @Column
    private String targetId; // 대상 id

    @Column
    private String content; // 신고내용

}