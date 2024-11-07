package com.movie.test.complaint.mapper;

import com.movie.test.complaint.dto.ComplaintDto;
import com.movie.test.complaint.dto.ComplaintSaveDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T10:39:21+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ComplaintSaveMapperImpl implements ComplaintSaveMapper {

    @Override
    public ComplaintDto toMetaDto(ComplaintSaveDto dto) {
        if ( dto == null ) {
            return null;
        }

        ComplaintDto.ComplaintDtoBuilder<?, ?> complaintDto = ComplaintDto.builder();

        complaintDto.createDate( dto.getCreateDate() );
        complaintDto.lastModifiedDate( dto.getLastModifiedDate() );
        complaintDto.userId( dto.getUserId() );
        complaintDto.targetId( dto.getTargetId() );
        complaintDto.type( dto.getType() );
        complaintDto.content( dto.getContent() );

        return complaintDto.build();
    }
}