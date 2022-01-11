package kar.sot.util;

import java.util.List;

public class NewsResponse {
	private String status;
	private int totalResults;
	private List<Article> articles;

	public NewsResponse(String status, int totalResults, List<Article> articles) {
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
