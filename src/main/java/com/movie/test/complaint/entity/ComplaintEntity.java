package com.movie.test.complaint.entity;

import com.movie.test.common.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "complaint")
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
    private String complaintUser; // 신고한 유저

    @Column
    private String getComplaintReportId; // 신고당한 감상문

    @Column
    private String content; // 신고내용

}
