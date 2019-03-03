package az.ruslan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import az.ruslan.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	List<Article>findByTitle(String tile);
	List<Article>findDistinctByCategory(String category);
	List<Article>findByTitleAndCategory(String title, String category);
}
