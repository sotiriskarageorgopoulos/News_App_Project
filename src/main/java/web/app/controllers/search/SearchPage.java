package web.app.controllers.search;

import io.javalin.http.Context;

import java.util.Collections;
import java.util.List;
import kar.sot.util.Article;
import kar.sot.validators.SupportedISOLanguages;

public class SearchPage {
	public static final String PATH = "/search";
	public static final String FETCH_BY_SOURCE_PATH = "/search_by_source";
	public static final String FETCH_BY_LANG = "/search_by_lang";
	public static final String FETCH_BY_TERM = "/search_by_term";
	public static final String FETCH_BY_CATEGORY = "/search_by_category";
	public static final String FETCH_BY_TIME_PERIOD = "/search_by_time_period";
	protected final Context ctx;
	public List<Article> articles;
	private SearchDAO s = new SearchDAO();
	public List<SupportedISOLanguages> langs = s.getAllSupportedLanguages();
	public List<String> categories = s.getSupportedCategories();

	public SearchPage(Context ctx) {
		this.ctx = ctx;
	}

	public void render() {
		ctx.render("search/search.jte", Collections.singletonMap("page", this));
	}
}
