package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByLanguage;
import kar.sot.util.Article;

public class SearchingByLanguageTest {

	@Test 
	public void getArticlesWithSupportedLanguage() throws IOException, InterruptedException, SearchingError {
		SearchingByLanguage sbl = new SearchingByLanguage();
		List<Article> articles1 = sbl.search("russian");
		assertThat("Must return many article",articles1.size(),greaterThan(0));
		
		List<Article> articles2 = sbl.search("Russian");
		assertThat("Must return many article",articles2.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithUnSupportedLanguage() {
		assertThrows(SearchingError.class, () -> {
			SearchingByLanguage sbl = new SearchingByLanguage();
			sbl.search("afar");
		});
	}
}
