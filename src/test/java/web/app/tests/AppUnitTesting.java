package web.app.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kar.sot.validators.SupportedISOCodes;
import kar.sot.validators.SupportedISOLanguages;
import web.app.controllers.history.SearchHistory;
import web.app.controllers.history.SearchHistoryDAO;
import web.app.controllers.index.IndexDAO;
import web.app.controllers.search.SearchDAO;

public class AppUnitTesting {

	@Test
	public void getSupportedCountries() {
		IndexDAO i = new IndexDAO();
		List<SupportedISOCodes> c = i.getSupportedCountries();
		assertThat("Must return many countries...", c.size(), greaterThan(0));
	}

	@Test
	public void getSupportedCategories() {
		IndexDAO i = new IndexDAO();
		List<String> categories = i.getSupportedCategories();
		assertThat("Must return many categories...", categories.size(), greaterThan(0));
	}

	@Test
	public void getAllSupportedLangs() {
		SearchDAO i = new SearchDAO();
		List<SupportedISOLanguages> langs = i.getAllSupportedLanguages();
		assertThat("Must return many languages", langs.size(), greaterThan(0));
	}

	@Test
	public void getFiveRecentSearched() {
		SearchHistoryDAO shd = new SearchHistoryDAO();
		List<SearchHistory> history = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SearchHistory sh = new SearchHistory("stg", LocalDateTime.now().plusDays(Math.round(Math.random() * 10)),
					null);
			history.add(sh);
		}
		List<SearchHistory> recentSearches = shd.getFiveRecentSearches(history);
		assertThat("The history must have 5 recent searches", recentSearches.size(), equalTo(5));
		// To show history objects in descending order
		recentSearches.stream().forEach(s -> System.out.println(s.getDateTime().toString()));
	}

}
