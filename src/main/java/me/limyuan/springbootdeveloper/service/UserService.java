package me.limyuan.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.limyuan.springbootdeveloper.domain.User;
import me.limyuan.springbootdeveloper.dto.AddUserRequest;
import me.limyuan.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    // 전달받은 유저 id로 유저를 검색해서 전달하는 메서드
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }

    // 이메일을 입력받아 users 테이블에서 유저를 찾고, 없으면 예외
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
