package web.app.controllers.index;

import java.time.*;

import io.javalin.http.Handler;
import kar.sot.NewsAPI;
import kar.sot.error.SearchingError;
import kar.sot.services.NewsServiceAPI;
import web.app.controllers.history.SearchHistory;
import web.app.util.SessionData;

public class IndexController {

	public static Handler serveIndexPage = ctx -> {
		IndexPage page = new IndexPage(ctx);
		page.render();
	};

	public static Handler fetchArticlesByCountry = ctx -> {
		String country = ctx.formParam("country");
		if (country != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				IndexPage page = new IndexPage(ctx);
				String desc = "The " + country + " searched.";
				page.allTopHeadings = n.searchByCountry(country);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.allTopHeadings);
				SessionData.history.add(h);
				ctx.sessionAttribute("history", SessionData.history);
				page.render();
			} catch (SearchingError e) {
				e.printStackTrace();
			}
		}

	};

	public static Handler fetchArticlesByCategory = ctx -> {
		String category = ctx.formParam("category");
		if (category != null) {
			try {
				NewsServiceAPI n = NewsAPI.getNewsService();
				IndexPage page = new IndexPage(ctx);
				String desc = "The " + category + " searched.";
				page.allTopHeadings = n.searchByCountryAndCategory(category);
				SearchHistory h = new SearchHistory(desc, LocalDateTime.now(), page.allTopHeadings);
				SessionData.history.add(h);
				ctx.sessionAttribute("history", SessionData.history);
				page.render();
			} catch (SearchingError ex) {
				ex.printStackTrace();
			}
		}
	};

}
