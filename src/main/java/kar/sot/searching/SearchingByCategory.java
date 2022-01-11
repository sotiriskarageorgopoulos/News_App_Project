package kar.sot.searching;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import kar.sot.error.SearchingError;
import kar.sot.util.Article;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingInterface;
import kar.sot.validators.ValidatingNewsCategory;

public class SearchingByCategory implements SearchingInterface<String> {

	/**
	 * Search news by category
	 * @author Sotirios Karageorgopoulos
	 * @param category - category of news
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SearchingError
	 * @return articles list
	 */
	@Override
	public List<Article> search(String category) throws IOException, InterruptedException, SearchingError {
		HttpClient client = HttpClient.newHttpClient();

		ValidatingNewsCategory vnc = new ValidatingNewsCategory();
		boolean isValidCategory = vnc.isValid(category);

		if (!isValidCategory) {
			throw new SearchingError("This category is not supported from News API...");
		}

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://newsapi.org/v2/top-headlines?category="
				+ category.toLowerCase().trim() + "&apiKey=e774591c5bef4863acbb636dcb9983ac")).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newsJSON = response.body();
		NewsResponseBuilder nrb = new NewsResponseBuilder();
		NewsResponse res = nrb.build(newsJSON);

		return res.getArticles();
	}

}
