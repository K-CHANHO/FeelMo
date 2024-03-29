package com.movie.test.user.userinfo.service;

import com.movie.test.api.s3.service.S3Service;
import com.movie.test.user.token.dto.JwtTokenDTO;
import com.movie.test.user.token.repository.TokenRepository;
import com.movie.test.user.token.service.JwtTokenProvider;
import com.movie.test.user.userinfo.dto.UserDTO;
import com.movie.test.user.userinfo.entity.UserEntity;
import com.movie.test.user.userinfo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final S3Service s3Service;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDTO newUserSave(UserDTO userDTO) {

        if(userRepository.existsByUid(userDTO.getUid())){
            UserEntity existUser = userRepository.findByUidAndType(userDTO.getUid(), userDTO.getType());
            return UserDTO.toDTO(existUser);
        }

        userDTO.setUserId(UUID.randomUUID().toString());
        userDTO.setNickname(makeNickname());
        if(userDTO.getProfileURL() != null) {
            userDTO.setProfileURL(s3Service.uploadImage(userDTO.getProfileURL()));
        } else {
            // TODO : 기본 프로필사진 설정하기.
        }
        userDTO.setRoles(List.of(new String[]{"USER"}));

        UserEntity user = UserDTO.toEntity(userDTO);

        UserEntity savedUser = userRepository.save(user);

        return UserDTO.toDTO(savedUser);

    }

    @Override
    public String makeNickname() {

        String[] firstWord = {"영화보는", "친절한", "상냥한", "팝콘먹는", "예매하는", "평화주의"};
        int randomIndex1 = (int)(Math.random() * firstWord.length);

        String[] secondWord = {"케빈", "금자씨", "안톤시거", "트루먼", "코코", "타노스"};
        int randomIndex2 = (int)(Math.random() * secondWord.length);

        String randomNumber = String.valueOf((int)(Math.random() * 10000));

        String nickname = firstWord[randomIndex1] + secondWord[randomIndex2] + randomNumber;

        boolean checkNickname = userRepository.existsByNickname(nickname);
        if (checkNickname) {
            nickname = makeNickname();
        }

        return nickname;
    }

    @Override
    public UserDTO getUserInfo(String userid) {

        UserDTO userDTO = UserDTO.toDTO(userRepository.findById(userid).get());

        return userDTO;
    }

    @Override
    public UserDTO getUserInfoByUidAndType(String uid, String type) {

        UserEntity existUser = userRepository.findByUidAndType(uid, type);

        if(existUser != null) {
            return UserDTO.toDTO(existUser);
        }

        return null;
    }

    @Override
    public JwtTokenDTO login(UserDTO userDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getType());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 토큰 생성
        JwtTokenDTO jwtTokenDTO = jwtTokenProvider.createToken(userDTO, authentication);

        return jwtTokenDTO;
    }

    @Override
    public List<String> checkUserRoles(String userId) {

        return Arrays.stream(userRepository.findById(userId).orElse(new UserEntity()).getRoles().split(",")).toList();
    }

    @Override
    public UserDTO updateUserinfo(UserDTO userDTO) {

        UserEntity userEntity = userRepository.findById(userDTO.getUserId()).get();
        UserEntity modifiedEntity = userEntity.toBuilder()
                .introduction(userDTO.getIntroduction())
                .nickname(userDTO.getNickname())
                .build();
        UserEntity saved = userRepository.save(modifiedEntity);


        return UserDTO.toDTO(saved);
    }
}
