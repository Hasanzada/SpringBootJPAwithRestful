package az.ruslan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.ruslan.entity.Article;
import az.ruslan.repository.ArticleRepository;

@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		List<Article>list = new ArrayList<Article>();
		articleRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Article getArticleById(long articleId) {
		Article article = articleRepository.findById(articleId).get();
		return article;
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		List<Article>list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
		if(list.size()>0) {
			return false;
		}else 
			articleRepository.save(article);
		return true;
	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
		
	}

	@Override
	public void deleteArticle(int articleId) {
		articleRepository.delete(getArticleById(articleId));		
	}

}
