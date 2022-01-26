package web.app.controllers.search;

import io.javalin.http.Handler;
import kar.sot.NewsAPI;
import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.services.NewsServiceAPI;
import web.app.controllers.history.SearchHistory;
import web.app.util.SessionData;

import java.time.*;
import java.util.Arrays;

public class SearchController {

	public static Handler serveSearchPage = ctx -> {
		SearchPage page = new SearchPage(ctx);
		page.render();
	};

	public static Handler fetchBySource = ctx -> {
		String source = ctx.formParam("source");
		if (source != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				SearchPage page = new SearchPage(ctx);
				String desc = "The " + source + " searched.";
				page.articles = n.searchBySource(source);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.articles);
				SessionData.history.add(h);
				ctx.sessionAttribute("history", SessionData.history);
				page.render();
			} catch (SearchingError e) {
				e.printStackTrace();
			}
		}
	};

	public static Handler fetchByLang = ctx -> {
		String lang = ctx.formParam("lang");
		if (lang != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				SearchPage page = new SearchPage(ctx);
				String desc = "News on " + lang + " language searched.";
				page.articles = n.searchByLang(lang);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.articles);
				SessionData.history = ctx.sessionAttribute("history");
				if (SessionData.history == null) {
					ctx.sessionAttribute("history", Arrays.asList(h));
				} else {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", SessionData.history);
				}
				page.render();
			} catch (SearchingError e) {
				e.printStackTrace();
			}
		}
	};

	public static Handler fetchByTerm = ctx -> {
		String term = ctx.formParam("term");
		if (term != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				SearchPage page = new SearchPage(ctx);
				String desc = "The term " + term + " searched.";
				page.articles = n.searchByTerm(term);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.articles);
				if (SessionData.history == null) {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", Arrays.asList(h));
				} else {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", SessionData.history);
				}
				page.render();
			} catch (SearchingError e) {
				e.printStackTrace();
			}
		}
	};

	public static Handler fetchByCategory = ctx -> {
		String category = ctx.formParam("category");
		if (category != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				SearchPage page = new SearchPage(ctx);
				String desc = "Category " + category + " searched.";
				page.articles = n.searchByCategory(category);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.articles);
				if (SessionData.history == null) {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", Arrays.asList(h));
				} else {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", SessionData.history);
				}
				page.render();
			} catch (SearchingError e) {
				e.printStackTrace();
			}
		}
	};

	public static Handler fetchByTimePeriod = ctx -> {
		String term = ctx.formParam("term");
		String fromDate = ctx.formParam("from_date");
		String toDate = ctx.formParam("to_date");

		try {
			if (term != null && fromDate != null && toDate != null) {
				NewsServiceAPI n = NewsAPI.getNewsService();
				SearchPage page = new SearchPage(ctx);
				String desc = "News was searched between " + fromDate.substring(0,10) + " and " + toDate.substring(0,10);
				page.articles = n.searchByTimePeriod(LocalDate.parse(fromDate.substring(0, 10)),
						LocalDate.parse(toDate.substring(0, 10)), term);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.articles);
				if (SessionData.history == null) {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", Arrays.asList(h));
				} else {
					SessionData.history.add(h);
					ctx.sessionAttribute("history", SessionData.history);
				}
				page.render();
			}
		} catch (SearchingError e) {
			e.printStackTrace();
		} catch (DateError e) {
			e.printStackTrace();
		}
	};
}
