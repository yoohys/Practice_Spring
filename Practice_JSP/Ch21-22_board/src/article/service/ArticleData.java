package article.service;

import article.model.Article;
import article.model.ArticleContent;
//Ariticle 객체와 ArticleContent 객체를 한 객체에 담기위한 용도
public class ArticleData {
	private Article article;
	private ArticleContent content;
	
	
	public ArticleData(Article article, ArticleContent content) {
		this.article = article;
		this.content = content;
	}
	public Article getArticle() {
		return article;
	}
	public String getContent() {
		return content.getContent();
	}
	
	
}
