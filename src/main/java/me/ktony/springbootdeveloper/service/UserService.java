package me.ktony.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ktony.springbootdeveloper.domain.User;
import me.ktony.springbootdeveloper.dto.AddUserRequest;
import me.ktony.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(
                    User.builder()
                    .email(dto.getEmail())
                    .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                    .build()
                ).getId();
    }

}
