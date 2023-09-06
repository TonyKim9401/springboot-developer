package me.ktony.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ktony.springbootdeveloper.config.jwt.TokenProvider;
import me.ktony.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected Token");
        }

        // 유효한 토큰인 때 RefreshToken 으로 사용자 Id 조회
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        // 토큰 제공자의 generateToken() 메서드를 호출해 새로운 AccessToken 생성
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }

}
