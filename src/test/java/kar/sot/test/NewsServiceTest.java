package kar.sot.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import kar.sot.NewsAPI;
import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.services.NewsServiceAPI;
import kar.sot.util.Article;

public class NewsServiceTest {
	@Test
	public void getArticlesWithSupportedCategory() throws SearchingError {
		NewsServiceAPI sbc = NewsAPI.getNewsService();
		List<Article> articles = sbc.searchByCategory("sports");
		assertThat("Must return many articles...", articles.size(), greaterThan(0));
	}
	
	@Test
	public void getArticlesWithUnSupportedCategory() {
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbc = NewsAPI.getNewsService();
			sbc.searchByCategory("football");
		});
		
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbc = NewsAPI.getNewsService();
			sbc.searchByCategory("fashion");
		});

	}
	
	@Test
	public void getArticlesWithSupportedCountry() throws SearchingError {
		NewsServiceAPI sbc = NewsAPI.getNewsService();
		List<Article> articles = sbc.searchByCountry("Russia");
		assertThat("Must return many articles: ",articles.size(),greaterThan(0));
	}
	
	@Test 
	public void getArticlesWithUnSupportedCountry() {
		
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbc = NewsAPI.getNewsService();
			sbc.searchByCategory("San Marino");
		});
		
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbc = NewsAPI.getNewsService();
			sbc.searchByCategory("Malta");
		});
	}
	
	@Test 
	public void getArticlesWithSupportedLanguage() throws SearchingError {
		NewsServiceAPI sbl = NewsAPI.getNewsService();
		List<Article> articles1 = sbl.searchByLang("russian");
		assertThat("Must return many article",articles1.size(),greaterThan(0));
		
		List<Article> articles2 = sbl.searchByLang("Russian");
		assertThat("Must return many article",articles2.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithUnSupportedLanguage() {
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbl = NewsAPI.getNewsService();
			sbl.searchByLang("afar");
		});
	}
	
	@Test 
	public void getArticlesWithValidTimePeriod() throws DateError, SearchingError {
		NewsServiceAPI sbt = NewsAPI.getNewsService();
		List<Article> articles = sbt.searchByTimePeriod(LocalDate.parse("2022-01-09"), LocalDate.parse("2022-01-10"), "chelsea");
		assertThat("Must return many articles",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithInvalidTimePeriod() {
		assertThrows(DateError.class, () -> {
			NewsServiceAPI  sbt = NewsAPI.getNewsService();
			sbt.searchByTimePeriod(LocalDate.parse("2022-01-10"), LocalDate.parse("2022-01-09"), "chelsea");
		});
	}
	
	@Test
	public void getArticlesWithNotExistingTitle() {
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbt = NewsAPI.getNewsService();
			sbt.searchByTimePeriod(LocalDate.parse("2022-01-09"), LocalDate.parse("2022-01-10"), "jjjmmmlk");
		});
	}
	
	@Test
	public void getArticlesWithExistingSource() throws SearchingError {
		NewsServiceAPI sbs = NewsAPI.getNewsService();
		List<Article> articles = sbs.searchBySource("rt");
		assertThat("Must return many articles",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithNotExistingSource() {
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbs = NewsAPI.getNewsService();
			sbs.searchBySource("lala");
		});
	}
	
	@Test
	public void getArticlesWithExistingTerm() throws SearchingError {
		NewsServiceAPI sbt = NewsAPI.getNewsService();
		List<Article> articles = sbt.searchByTerm("apple");
		assertThat("Must return articles...",articles.size(),greaterThan(0));
	}
	
	@Test
	public void getArticlesWithNotExistingTerm() {
		assertThrows(SearchingError.class, () -> {
			NewsServiceAPI sbt = NewsAPI.getNewsService();
			sbt.searchByTerm("mlka");
		});
	}
	
	@Test
	public void getArticlesByCountries() throws IOException, InterruptedException, SearchingError {
		NewsServiceAPI suc = NewsAPI.getNewsService();
		List<Article> articles = suc.searchByUserCountry();
		assertThat("Must return many articles: ", articles.size(), greaterThan(0));
	}
}
