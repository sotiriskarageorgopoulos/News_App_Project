package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByTerm;
import kar.sot.util.Article;


public class SearchingByTermTest {

	@Test
	public void getArticlesWithExistingTerm() throws IOException, InterruptedException, SearchingError {
		SearchingByTerm sbt = new SearchingByTerm();
		List<Article> articles = sbt.search("apple");
		assertThat("Must return articles...",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithNotExistingTerm() {
		assertThrows(SearchingError.class, () -> {
			SearchingByTerm sbt = new SearchingByTerm();
			sbt.search("mlka");
		});
	}
	
}
