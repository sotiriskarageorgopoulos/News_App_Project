package kar.sot.searching;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;
import java.net.http.HttpResponse;
import java.util.Optional;

import kar.sot.error.SearchingError;
import kar.sot.util.Article;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingInterface;
import kar.sot.validators.SupportedISOLanguages;
import kar.sot.validators.ValidatingLanguage;

public class SearchingByLanguage implements SearchingInterface<String> {

	/**
	 * Search news by language
	 * @author Sotirios Karageorgopoulos 
	 * @param language - The language of articles
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> search(String language) throws IOException, InterruptedException, SearchingError {
		HttpClient client = HttpClient.newHttpClient();

		ValidatingLanguage vl = new ValidatingLanguage();
		boolean isValidLang = vl.isValid(language);

		if (!isValidLang)
			throw new SearchingError("This language is not supported from News API...");

		List<SupportedISOLanguages> langs = Arrays.asList(SupportedISOLanguages.values());
		Optional<SupportedISOLanguages> lang = langs.stream()
				.filter(l -> l.getLanguage().equalsIgnoreCase(language.trim())).findFirst();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://newsapi.org/v2/top-headlines?language="
				+ lang.get().getIsoCode() + "&apiKey=e774591c5bef4863acbb636dcb9983ac")).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newsJSON = response.body();
		NewsResponseBuilder nrb = new NewsResponseBuilder();
		NewsResponse res = nrb.build(newsJSON);

		return res.getArticles();
	}
}
