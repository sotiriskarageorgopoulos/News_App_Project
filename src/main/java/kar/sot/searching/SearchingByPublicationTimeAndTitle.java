package kar.sot.searching;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.List;

import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.util.Article;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.interfaces.SearchingByDateInterface;

public class SearchingByPublicationTimeAndTitle implements SearchingByDateInterface<LocalDate, String> {

	/**
	 * Search news by time period and article's title
	 * @author Sotirios Karageorgopoulos 
	 * @param dateFrom - the initial date
	 * @param dateTo - the final date
	 * @param title - the ariticle's title
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @throws DateError
	 * @return articles list
	 */
	public List<Article> search(LocalDate dateFrom, LocalDate dateTo, String title)
			throws IOException, InterruptedException, SearchingError, DateError {
		if (!dateFrom.isBefore(dateTo))
			throw new DateError("Wrong date inputs: dateFrom is always before dateTo...");

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://newsapi.org/v2/everything?q=" + title + "&from=" + dateFrom.toString() + "&to="
						+ dateTo.toString() + "&sortBy=popularityt&apiKey=e774591c5bef4863acbb636dcb9983ac"))
				.build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String newJSON = response.body();

		NewsResponseBuilder nrb = new NewsResponseBuilder();
		NewsResponse res = nrb.build(newJSON);
		List<Article> articles = res.getArticles();

		if (articles.size() == 0)
			throw new SearchingError("Not found articles...");

		return articles;
	}

}
