package com.std.SpringBootTest2.article;

import com.std.SpringBootTest2.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList(){
        return articleRepository.findAll();
    }
    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()){
            return article.get();
        }else {
            throw new DataNotFoundException("오류");
        }
    }
    public void create(String title, String content){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }
}
