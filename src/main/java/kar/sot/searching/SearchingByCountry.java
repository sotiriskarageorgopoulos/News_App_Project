package kar.sot.searching;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.net.URI;
import kar.sot.error.SearchingError;

import kar.sot.util.Article;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingInterface;
import kar.sot.validators.ValidatingCountry;
import kar.sot.validators.SupportedISOCodes;

public class SearchingByCountry implements SearchingInterface<String> {

	/**
	 * Searching top news by selected country.
	 * @author Sotirios Karageorgopoulos 
	 * @param country - Selected country
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> search(String country) throws IOException, InterruptedException, SearchingError {
		HttpClient client = HttpClient.newHttpClient();

		ValidatingCountry vc = new ValidatingCountry();
		boolean isValidCountry = vc.isValid(country);

		if (!isValidCountry) {
			throw new SearchingError("This country is not supported from News API.");
		}

		List<SupportedISOCodes> codes = Arrays.asList(SupportedISOCodes.values());
		Optional<SupportedISOCodes> code = codes.stream()
				.filter(c -> c.getCountry().trim().equalsIgnoreCase(country.trim())).findFirst();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://newsapi.org/v2/top-headlines?country="
				+ code.get().getCountryCode() + "&apiKey=e774591c5bef4863acbb636dcb9983ac")).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newsJSON = response.body();
		NewsResponseBuilder nrb = new NewsResponseBuilder();
		NewsResponse res = nrb.build(newsJSON);

		return res.getArticles();
	}
}
