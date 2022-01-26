package web.app.controllers.history;

import java.util.Collections;
import java.util.List;

import io.javalin.http.Context;
import kar.sot.util.Article;

public class SearchHistoryPage {
	public static final String PATH = "/history";
	public static final String PATH_FETCH_FROM_HISTORY = "/fetch_from_history";
	protected final Context ctx;
	public List<SearchHistory> history = null;
	public List<Article> articles = null;
	
	public SearchHistoryPage(Context ctx) {
		this.ctx = ctx;
	}
	
	public void render() {
		ctx.render("history/search_history.jte",Collections.singletonMap("page", this));
	}
}
