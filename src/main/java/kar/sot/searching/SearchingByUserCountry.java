package kar.sot.searching;

import java.util.List;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import kar.sot.util.Article;
import kar.sot.util.Country;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingCountryInterface;
import kar.sot.validators.ValidatingISOCountryCodes;
import kar.sot.error.SearchingError;

public class SearchingByUserCountry implements SearchingCountryInterface {

	/**
	 * Search top news by user's country.
	 * @author Sotirios Karageorgopoulos 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> search() throws IOException, InterruptedException, SearchingError {
		HttpClient client = HttpClient.newHttpClient();

		SearchingMyCountry smc = new SearchingMyCountry();
		Country country = smc.searchMyCountry();

		ValidatingISOCountryCodes vc = new ValidatingISOCountryCodes();
		boolean isValidCode = vc.isValid(country.getCountryCode());

		if (!isValidCode) {
			throw new SearchingError("This country code is not supported from News API...");
		}

		HttpRequest requestNews = HttpRequest.newBuilder()
				.uri(URI.create("https://newsapi.org/v2/top-headlines?country=" + country.getCountryCode().toLowerCase()
						+ "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
				.build();

		HttpResponse<String> responseNews = client.send(requestNews, BodyHandlers.ofString());
		String newsJSON = responseNews.body();

		NewsResponseBuilder cnr = new NewsResponseBuilder();
		NewsResponse res = cnr.build(newsJSON);

		return res.getArticles();
	}
}
