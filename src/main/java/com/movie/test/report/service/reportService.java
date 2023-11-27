package com.movie.test.report.service;

import com.movie.test.report.dto.reportDTO;
import com.movie.test.report.entity.reportEntity;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public interface reportService {

    String registReport(reportDTO reportDTO);

    reportDTO getReport(String reportId);

    String modifyReport(reportDTO reportDTO);

    void deleteReport(String reportId);


    default reportEntity dtoTOentity(reportDTO reportDTO) {
        reportEntity report = reportEntity.builder()
                .reportId(reportDTO.getReportId())
                .title(reportDTO.getTitle())
                .content(reportDTO.getContent().getBytes(StandardCharsets.UTF_8))
                .userId(reportDTO.getUserId())
                .build();

        return report;
    }

    default reportDTO entityTOdto(reportEntity reportEntity){
        reportDTO report = reportDTO.builder()
                .reportId(reportEntity.getReportId())
                .title(reportEntity.getTitle())
                .content(new String(reportEntity.getContent(), StandardCharsets.UTF_8))
                .userId(reportEntity.getUserId())
                .createDate(reportEntity.getCreateDate())
                .lastModifiedDate(reportEntity.getLastModifiedDate())
                .build();

        return report;
    }
}