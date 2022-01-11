package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByCountry;
import kar.sot.util.Article;

public class SearchingByCountryTest {
	
	@Test
	public void getArticlesWithSupportedCountry() throws IOException, InterruptedException, SearchingError {
		SearchingByCountry sbc = new SearchingByCountry();
		List<Article> articles = sbc.search("Russia");
		assertThat("Must return many articles: ",articles.size(),greaterThan(0));
	}
	
	@Test 
	public void getArticlesWithUnSupportedCountry() {
		
		assertThrows(SearchingError.class, () -> {
			SearchingByCountry sbc = new SearchingByCountry();
			sbc.search("San Marino");
		});
		
		assertThrows(SearchingError.class, () -> {
			SearchingByCountry sbc = new SearchingByCountry();
			sbc.search("Malta");
		});
	}
}
