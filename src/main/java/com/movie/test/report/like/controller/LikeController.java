package com.movie.test.report.like.controller;

import com.movie.test.report.like.dto.LikeDTO;
import com.movie.test.report.like.service.LikeService;
import com.querydsl.core.types.dsl.BooleanExpression;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    @Operation(summary = "좋아요 등록/취소", description = "좋아요를 등록 또는 취소합니다.")
    @Parameters(value = {
            @Parameter(name = "reportId", description = "감상문의 id", required = true),
            @Parameter(name = "userId", description = "유저의 id", required = true),
    })
    @PostMapping("/regist")
    public ResponseEntity registOrDeleteLike(LikeDTO likeDTO) {

        likeService.registOrDelete(likeDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity checkLikst(LikeDTO likeDTO){

        Boolean isExistLike = false;
        LikeDTO dto = likeService.checkLike(likeDTO);

        if(dto != null){
            isExistLike = true;
        }

        return new ResponseEntity(isExistLike, HttpStatus.OK);
    }
}
