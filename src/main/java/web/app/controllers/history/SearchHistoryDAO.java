package web.app.controllers.history;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchHistoryDAO {

	public List<SearchHistory> getFiveRecentSearches(List<SearchHistory> history) {
		return history.stream().sorted(Comparator.comparing(SearchHistory::getDateTime).reversed()).limit(5)
				.collect(Collectors.toList());
	}

}
