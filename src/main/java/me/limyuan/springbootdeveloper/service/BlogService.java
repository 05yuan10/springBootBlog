package me.limyuan.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.limyuan.springbootdeveloper.domain.Article;
import me.limyuan.springbootdeveloper.dto.AddArticleRequest;
import me.limyuan.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // 빈을 생성자로 생성: final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
