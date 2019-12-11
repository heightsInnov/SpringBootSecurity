package com.concretepage.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.concretepage.entity.Article;

public interface IArticleDAO extends CrudRepository<Article, String> {
	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

	boolean articleExists(String title, String category);
}