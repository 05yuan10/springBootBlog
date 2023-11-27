package me.limyuan.springbootdeveloper.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.limyuan.springbootdeveloper.domain.Article;
import me.limyuan.springbootdeveloper.dto.ArticleListViewResponse;
import me.limyuan.springbootdeveloper.dto.ArticleViewResponse;
import me.limyuan.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 블로그 글 리스트 저장

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    // 1. id 키를 가진 쿼리 파라미터의 값을 id 변수에 매핑(id는 없을 수도 있음)
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        // 게시글 생성하는 경우
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        }
        // 게시글 수정하는 경우
        else{
            Article article = blogService.findById(id); // 기존 값을 가져온다.
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
