package web.app.controllers.search;

import kar.sot.util.Article;
import kar.sot.validators.SupportedISOLanguages;
import kar.sot.validators.SupportedNewsCategories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchDAO {
	private List<Article> articles = null;

	public List<SupportedISOLanguages> getAllSupportedLanguages() {
		return Arrays.asList(SupportedISOLanguages.values());
	}

	public List<String> getSupportedCategories() {
		return Arrays.stream(SupportedNewsCategories.values()).map(SupportedNewsCategories::getCategory)
				.collect(Collectors.toList());
	}

}
