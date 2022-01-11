package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingBySource;
import kar.sot.util.Article;


public class SearchingBySourceTest {
	
	@Test
	public void getArticlesWithExistingSource() throws IOException, InterruptedException, SearchingError {
		SearchingBySource sbs = new SearchingBySource();
		List<Article> articles = sbs.search("rt");
		assertThat("Must return many articles",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithNotExistingSource() {
		assertThrows(SearchingError.class, () -> {
			SearchingBySource sbs = new SearchingBySource();
			sbs.search("lala");
		});
	}
}
