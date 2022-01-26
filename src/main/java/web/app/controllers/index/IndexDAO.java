package web.app.controllers.index;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kar.sot.util.Article;
import kar.sot.validators.SupportedISOCodes;
import kar.sot.validators.SupportedNewsCategories;
import kar.sot.error.SearchingError;
import kar.sot.NewsAPI;
import kar.sot.services.NewsServiceAPI;

public class IndexDAO {
	private List<Article> articles;
	
	public List<Article> getAllTopHeadingsByUserCountry() {
		try {
			NewsServiceAPI n = NewsAPI.getNewsService();
			articles = n.searchByUserCountry();
		} catch(SearchingError e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public List<SupportedISOCodes> getSupportedCountries() {
		return Arrays.asList(SupportedISOCodes.values());			
	}
	
	public List<String> getSupportedCategories() {
		return Arrays.stream(SupportedNewsCategories.values())
					 .map(SupportedNewsCategories::getCategory)
					 .collect(Collectors.toList());
	}
}
