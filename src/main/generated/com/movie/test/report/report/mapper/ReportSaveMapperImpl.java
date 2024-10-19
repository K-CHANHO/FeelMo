package com.movie.test.report.report.mapper;

import com.movie.test.report.report.dto.ReportDto;
import com.movie.test.report.report.dto.ReportSaveDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
)
public class ReportSaveMapperImpl implements ReportSaveMapper {

    @Override
    public ReportDto toReportDto(ReportSaveDto reportSaveDto) {
        if ( reportSaveDto == null ) {
            return null;
        }

        ReportDto.ReportDtoBuilder<?, ?> reportDto = ReportDto.builder();

        reportDto.title( reportSaveDto.getTitle() );
        reportDto.content( reportSaveDto.getContent() );
        reportDto.userId( reportSaveDto.getUserId() );
        reportDto.movieId( reportSaveDto.getMovieId() );
        reportDto.imageUrl( reportSaveDto.getImageUrl() );
        reportDto.tagString( reportSaveDto.getTagString() );

        return reportDto.build();
    }

    @Override
    public ReportSaveDto toReportSaveDto(ReportDto reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        ReportSaveDto.ReportSaveDtoBuilder reportSaveDto = ReportSaveDto.builder();

        reportSaveDto.title( reportDto.getTitle() );
        reportSaveDto.content( reportDto.getContent() );
        reportSaveDto.movieId( reportDto.getMovieId() );
        reportSaveDto.imageUrl( reportDto.getImageUrl() );
        reportSaveDto.tagString( reportDto.getTagString() );
        reportSaveDto.userId( reportDto.getUserId() );

        return reportSaveDto.build();
    }
}
