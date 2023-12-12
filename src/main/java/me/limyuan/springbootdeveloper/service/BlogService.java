package me.limyuan.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.limyuan.springbootdeveloper.domain.Article;
import me.limyuan.springbootdeveloper.dto.AddArticleRequest;
import me.limyuan.springbootdeveloper.dto.UpdateArticleRequest;
import me.limyuan.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // 빈을 생성자로 생성: final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request, String userName) {
        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(Long id) {
         blogRepository.deleteById(id);
    }
    @Transactional // 트랜잭션 메서드: 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할
    public Article update(Long id, UpdateArticleRequest updateArticleRequest) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());

        return article;
    }
}