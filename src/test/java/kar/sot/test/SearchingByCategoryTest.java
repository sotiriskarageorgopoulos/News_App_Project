package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByCategory;
import kar.sot.util.Article;

public class SearchingByCategoryTest {

	@Test
	public void getArticlesWithSupportedCategory() throws IOException, InterruptedException, SearchingError {
		SearchingByCategory sbc = new SearchingByCategory();
		List<Article> articles = sbc.search("sports");
		assertThat("Must return many articles...", articles.size(), greaterThan(0));
	}
	
	@Test
	public void getArticlesWithUnSupportedCategory() {
		assertThrows(SearchingError.class, () -> {
			SearchingByCategory sbc = new SearchingByCategory();
			sbc.search("football");
		});
		
		assertThrows(SearchingError.class, () -> {
			SearchingByCategory sbc = new SearchingByCategory();
			sbc.search("fashion");
		});

	}
}
