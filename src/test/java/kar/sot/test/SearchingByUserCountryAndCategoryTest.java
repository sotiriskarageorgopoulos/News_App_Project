package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByUserCountryAndCategory;
import kar.sot.util.Article;


public class SearchingByUserCountryAndCategoryTest {

	@Test
	public void getArticlesWithSupportedCategory() throws IOException, InterruptedException, SearchingError {
		SearchingByUserCountryAndCategory s = new SearchingByUserCountryAndCategory();
		List<Article> articles = s.search("business");
		assertThat("Must return many articles: ", articles.size(), greaterThan(0));
	}

	@Test
	public void getArticlesWithUnSupportedCategory()
			throws IOException, InterruptedException, SearchingError {
		assertThrows(SearchingError.class, () -> {
			SearchingByUserCountryAndCategory s = new SearchingByUserCountryAndCategory();
			s.search("games");
		});
		assertThrows(SearchingError.class, () -> {
			SearchingByUserCountryAndCategory s = new SearchingByUserCountryAndCategory();
			s.search("football");
		});
	}
}
