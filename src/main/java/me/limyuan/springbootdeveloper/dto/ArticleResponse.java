package me.limyuan.springbootdeveloper.dto;

import lombok.Builder;
import lombok.Getter;
import me.limyuan.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private String title;
    private String content;

    // 엔티티를 인수로 받는 생성자
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
