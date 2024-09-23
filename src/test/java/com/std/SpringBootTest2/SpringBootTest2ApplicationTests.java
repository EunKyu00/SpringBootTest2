package com.std.SpringBootTest2;

import com.std.SpringBootTest2.article.Article;
import com.std.SpringBootTest2.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBootTest2ApplicationTests {
	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void contextLoads() {
		Article a = new Article();
		a.setTitle("이은규");
		a.setContent("2차 테스트");
		a.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(a);
	}

}
