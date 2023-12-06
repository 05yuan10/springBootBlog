package me.limyuan.springbootdeveloper.repository;

import me.limyuan.springbootdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Ref;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long id);

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
