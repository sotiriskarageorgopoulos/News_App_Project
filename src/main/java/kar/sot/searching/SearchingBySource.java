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

public class SearchingBySource implements SearchingInterface<String> {
	
	/**
	 * Search news by source
	 * @author Sotirios Karageorgopoulos 
	 * @param source - the source of news
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> search(String source) throws SearchingError, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://newsapi.org/v2/top-headlines?sources="
				+ source.toLowerCase().trim() + "&apiKey=e774591c5bef4863acbb636dcb9983ac")).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newsJSON = response.body();

		NewsResponseBuilder nrb = new NewsResponseBuilder();
		NewsResponse res = nrb.build(newsJSON);
		List<Article> articles = res.getArticles();

		if (articles.size() == 0)
			throw new SearchingError("No articles found...");

		return articles;
	}

}
