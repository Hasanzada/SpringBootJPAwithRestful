package az.ruslan.service;

import java.util.List;

import az.ruslan.entity.Article;

public interface IArticleService {
	List<Article>getAllArticles();
	Article getArticleById(long articleId);
	boolean addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(int articleId);
}
