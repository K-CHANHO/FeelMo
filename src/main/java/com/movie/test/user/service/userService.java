package com.movie.test.user.service;

import com.movie.test.user.dto.userDTO;
import com.movie.test.user.entity.userEntity;

public interface userService {

    userDTO newUserSave(userDTO userDTO);

    String makeNickname();

    userDTO getUserInfo(String userid);

    default userEntity dtoTOentity(userDTO userDTO) {
        userEntity entity = userEntity.builder()
                .uid(userDTO.getUid())
                .userId(userDTO.getUserId())
                .type(userDTO.getType())
                .nickname(userDTO.getNickname())
                .create_date(userDTO.getCreate_date())
                .last_login_date(userDTO.getLast_login_date())
                .profileURL(userDTO.getProfileURL())
                .build();

        return entity;
    }

    default userDTO entityTOdto(userEntity userEntity) {

        userDTO dto = userDTO.builder()
                .uid(userEntity.getUid())
                .userId(userEntity.getUserId())
                .type(userEntity.getType())
                .nickname(userEntity.getNickname())
                .create_date(userEntity.getCreate_date())
                .last_login_date(userEntity.getLast_login_date())
                .profileURL(userEntity.getProfileURL())
                .build();

        return dto;
    }
}
