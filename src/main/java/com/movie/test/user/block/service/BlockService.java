package com.movie.test.user.block.service;

import com.movie.test.user.block.dto.BlockDeleteDto;
import com.movie.test.user.block.dto.BlockDto;
import com.movie.test.user.block.dto.BlockSaveDto;
import com.movie.test.user.follow.dto.FollowListSearchDTO;
import com.movie.test.user.userinfo.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface BlockService {
    BlockDto saveBlock(BlockSaveDto blockSaveDto);

    String deleteBlock(BlockDeleteDto blockDeleteDto);

    Slice<UserDto> getBlockList(FollowListSearchDTO blockListSearchDTO, Pageable pageable);

    boolean isBlocking(String userId, String targetId);

    Long countBlock(String userId);
}
