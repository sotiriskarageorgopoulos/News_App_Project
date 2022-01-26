package web.app.server;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.rendering.template.JavalinJte;
import web.app.controllers.history.SearchHistoryController;
import web.app.controllers.history.SearchHistoryPage;
import web.app.controllers.index.IndexController;
import web.app.controllers.index.IndexPage;
import web.app.controllers.search.SearchController;
import web.app.controllers.search.SearchPage;
import web.app.util.TemplateEngineCreator;

public class Server {
	public static boolean isDevEnv = System.getProperty("enviroment") == null;
	private static Javalin app;

	public static void main(String[] args) {
		app = Javalin.create(cfg -> {
			JavalinJte.configure(TemplateEngineCreator.create(isDevEnv));
			cfg.addStaticFiles("/public", Location.CLASSPATH);
		}).start(4568);

		app.get(IndexPage.PATH, IndexController.serveIndexPage);
		app.get(SearchPage.PATH, SearchController.serveSearchPage);
		app.get(SearchHistoryPage.PATH, SearchHistoryController.serveHistoryPage);
		app.post(IndexPage.PATH_FETCH_BY_COUNTRY, IndexController.fetchArticlesByCountry);
		app.post(IndexPage.PATH_FETCH_BY_CATEGORY, IndexController.fetchArticlesByCategory);
		app.post(SearchPage.FETCH_BY_SOURCE_PATH, SearchController.fetchBySource);
		app.post(SearchPage.FETCH_BY_LANG, SearchController.fetchByLang);
		app.post(SearchPage.FETCH_BY_TERM, SearchController.fetchByTerm);
		app.post(SearchPage.FETCH_BY_TIME_PERIOD, SearchController.fetchByTimePeriod);
		app.post(SearchPage.FETCH_BY_CATEGORY, SearchController.fetchByCategory);
		app.post(SearchHistoryPage.PATH_FETCH_FROM_HISTORY, SearchHistoryController.fetchFromHistory);
	}

	public Javalin getApp() {
		return app;
	}
}