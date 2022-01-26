package web.app.controllers.history;

import java.util.List;

import io.javalin.http.Handler;

public class SearchHistoryController {

	public static Handler serveHistoryPage = ctx -> {
		SearchHistoryPage page = new SearchHistoryPage(ctx);
		List<SearchHistory> history = ctx.sessionAttribute("history");
		page.articles = null;
		if (history != null) {
			SearchHistoryDAO sh = new SearchHistoryDAO();
			page.history = sh.getFiveRecentSearches(history);
		}
		page.render();
	};

	public static Handler fetchFromHistory = ctx -> {
		SearchHistoryPage page = new SearchHistoryPage(ctx);
		List<SearchHistory> history = ctx.sessionAttribute("history");
		String id = ctx.formParam("id");
		if (history != null) {
			page.articles = history.stream().filter(h -> h.getId().equals(id)).map(SearchHistory::getArticles)
					.findFirst().get();
		}
		page.render();
	};

}
