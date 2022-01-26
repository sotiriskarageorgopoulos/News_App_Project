package web.app.controllers.index;

import java.util.Collections;
import java.util.List;
import io.javalin.http.Context;
import kar.sot.util.Article;
import kar.sot.validators.SupportedISOCodes;

public class IndexPage {
	public static final String PATH = "/index";
	public static final String PATH_FETCH_BY_COUNTRY = "/fetch_by_country";
	public static final String PATH_FETCH_BY_CATEGORY = "/fetch_by_category";
	protected final Context ctx;
	private IndexDAO i = new IndexDAO();
	public List<Article> allTopHeadings = i.getAllTopHeadingsByUserCountry();
	public List<SupportedISOCodes> allCountries = i.getSupportedCountries();
	public List<String> allCategories = i.getSupportedCategories();
	
	public IndexPage(Context ctx) {
		this.ctx = ctx;
	}
	
	public void render() {
		ctx.render("index/index.jte",Collections.singletonMap("page", this));
	}
}
