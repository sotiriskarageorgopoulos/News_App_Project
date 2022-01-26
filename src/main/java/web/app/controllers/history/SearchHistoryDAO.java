package web.app.controllers.history;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import kar.sot.util.Article;

public class SearchHistoryDAO {

	public List<SearchHistory> getFiveRecentSearches(List<SearchHistory> history) {
		return history.stream().sorted(Comparator.comparing(SearchHistory::getDateTime).reversed()).limit(5)
				.collect(Collectors.toList());
	}
	
	public List<Article> getArticles(List<SearchHistory> history, String id) {
		return history.stream().filter(h -> h.getId().equals(id)).map(SearchHistory::getArticles)
					.findFirst().get();
	}

}
