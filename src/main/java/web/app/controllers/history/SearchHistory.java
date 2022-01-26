package web.app.controllers.history;

import java.time.*;
import java.util.List;
import java.util.UUID;

import kar.sot.util.Article;

public class SearchHistory {
	private String desc;
	private final String id = UUID.randomUUID().toString();
	private LocalDateTime dateTime;
	private List<Article> articles;

	public SearchHistory(String desc, LocalDateTime dateTime, List<Article> articles) {
		this.desc = desc;
		this.dateTime = dateTime;
		this.articles = articles;
	}

	public String getId() {
		return id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
