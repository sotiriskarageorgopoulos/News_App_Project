package kar.sot.test;

import java.io.IOException;

import org.junit.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByUserCountry;
import kar.sot.util.Article;

public class SearchingByUserCountryTest {

	@Test
	public void getArticlesByCountries() throws IOException, InterruptedException, SearchingError {
		SearchingByUserCountry suc = new SearchingByUserCountry();
		List<Article> articles = suc.search();
		assertThat("Must return many articles: ", articles.size(), greaterThan(0));
	}
}
