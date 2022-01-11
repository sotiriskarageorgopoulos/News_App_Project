package kar.sot.searching;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import kar.sot.error.SearchingError;
import kar.sot.util.Article;
import kar.sot.util.Country;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingInterface;
import kar.sot.util.NewsResponse;
import kar.sot.validators.ValidatingISOCountryCodes;
import kar.sot.validators.ValidatingNewsCategory;

public class SearchingByUserCountryAndCategory implements SearchingInterface<String> {

	/**
	 * Search top news by their category and user's country.
	 * @author Sotirios Karageorgopoulos 
	 * @param category - news category
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @throws URISyntaxException
	 * @return articles list
	 */
	public List<Article> search(String category) throws IOException, InterruptedException, SearchingError {
		HttpClient client = HttpClient.newHttpClient();

		SearchingMyCountry smc = new SearchingMyCountry();
		Country country = smc.searchMyCountry();

		ValidatingISOCountryCodes vc = new ValidatingISOCountryCodes();
		boolean isValidCode = vc.isValid(country.getCountryCode());

		if (!isValidCode) {
			throw new SearchingError("This country code is not supported from News API...");
		}

		ValidatingNewsCategory vnc = new ValidatingNewsCategory();
		boolean isValidCategory = vnc.isValid(category);

		if (!isValidCategory) {
			throw new SearchingError("This category is not supported from News API...");
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://newsapi.org/v2/top-headlines?country=" + country.getCountryCode().toLowerCase()
						+ "&category=" + category + "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
				.build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newsJSON = response.body();

		NewsResponseBuilder cnr = new NewsResponseBuilder();
		NewsResponse res = cnr.build(newsJSON);

		return res.getArticles();
	}
}
