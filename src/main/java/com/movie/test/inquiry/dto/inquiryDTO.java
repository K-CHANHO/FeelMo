package com.movie.test.inquiry.dto;

import com.movie.test.common.dto.baseTimeDTO;
import com.movie.test.inquiry.entity.inquiryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.nio.charset.StandardCharsets;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class inquiryDTO extends baseTimeDTO {

    private String inquiryId;
    private String userId;
    private String title; // 문의제목
    private String content; // 문의내용
    private String answerYN; // 답변 여부

    public static inquiryDTO toDTO(inquiryEntity inquiryEntity){

        inquiryDTO inquiry = inquiryDTO.builder()
                .inquiryId(inquiryEntity.getInquiryId())
                .userId(inquiryEntity.getUserId())
                .title(inquiryEntity.getTitle())
                .content(new String(inquiryEntity.getContent(), StandardCharsets.UTF_8))
                .answerYN(inquiryEntity.getAnswerYN())
                .createDate(inquiryEntity.getCreateDate())
                .lastModifiedDate(inquiryEntity.getLastModifiedDate())
                .build();

        return inquiry;
    }

    public static inquiryEntity toEntity(inquiryDTO inquiryDTO) {

        inquiryEntity inquiry = inquiryEntity.builder()
                .inquiryId(inquiryDTO.getInquiryId())
                .userId(inquiryDTO.getUserId())
                .title(inquiryDTO.getTitle())
                .content(inquiryDTO.getContent().getBytes(StandardCharsets.UTF_8))
                .answerYN(inquiryDTO.getAnswerYN())
                .build();

        return inquiry;
    }


}
