package kar.sot.test;

import org.junit.*;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.searching.SearchingByPublicationTimeAndTitle;
import kar.sot.util.Article;

public class SearchingByPublicationTimeAndTitleTest {
	@Test 
	public void getArticlesWithValidTimePeriod() throws IOException, InterruptedException, DateError, SearchingError {
		SearchingByPublicationTimeAndTitle sbt = new SearchingByPublicationTimeAndTitle();
		List<Article> articles = sbt.search(LocalDate.parse("2022-01-09"), LocalDate.parse("2022-01-10"), "chelsea");
		assertThat("Must return many articles",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithInvalidTimePeriod() {
		assertThrows(DateError.class, () -> {
			SearchingByPublicationTimeAndTitle  sbt = new SearchingByPublicationTimeAndTitle();
			sbt.search(LocalDate.parse("2022-01-10"), LocalDate.parse("2022-01-09"), "chelsea");
		});
	}
	
	@Test
	public void getArticlesWithNotExistingTitle() {
		assertThrows(SearchingError.class, () -> {
			SearchingByPublicationTimeAndTitle  sbt = new SearchingByPublicationTimeAndTitle();
			sbt.search(LocalDate.parse("2022-01-09"), LocalDate.parse("2022-01-10"), "jjjmmmlk");
		});
	}
}
