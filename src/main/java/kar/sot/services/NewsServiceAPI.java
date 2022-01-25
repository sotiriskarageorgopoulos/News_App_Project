package kar.sot.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.util.Article;
import kar.sot.util.Country;
import kar.sot.util.NewsResponse;
import kar.sot.util.NewsResponseBuilder;
import kar.sot.util.SearchingMyCountry;
import kar.sot.util.interfaces.NewsInterface;
import kar.sot.validators.SupportedISOCodes;
import kar.sot.validators.SupportedISOLanguages;
import kar.sot.validators.ValidatingCountry;
import kar.sot.validators.ValidatingISOCountryCodes;
import kar.sot.validators.ValidatingLanguage;
import kar.sot.validators.ValidatingNewsCategory;

public class NewsServiceAPI implements NewsInterface<String, LocalDate> {

	/**
	 * Search top news by user's country.
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchByUserCountry() throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			SearchingMyCountry smc = new SearchingMyCountry();
			Country country = smc.searchMyCountry();

			ValidatingISOCountryCodes vc = new ValidatingISOCountryCodes();
			boolean isValidCode = vc.isValid(country.getCountryCode());

			if (!isValidCode) {
				throw new SearchingError("This country code is not supported from News API...");
			}

			HttpRequest requestNews = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/top-headlines?country="
							+ country.getCountryCode().toLowerCase() + "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(requestNews, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();

			NewsResponseBuilder cnr = new NewsResponseBuilder();
			NewsResponse res = cnr.build(newsJSON);

			return res.getArticles();
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in counnection", e);
		}
	}

	/**
	 * Search top news by their category and user's country.
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param category - news category
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @throws URISyntaxException
	 * @return articles list
	 */
	public List<Article> searchByCountryAndCategory(String category) throws SearchingError {
		try {
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
					.uri(URI.create(
							"https://newsapi.org/v2/top-headlines?country=" + country.getCountryCode().toLowerCase()
									+ "&category=" + category + "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();

			NewsResponseBuilder cnr = new NewsResponseBuilder();
			NewsResponse res = cnr.build(newsJSON);

			return res.getArticles();
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Search news by category
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param category - category of news
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchByCategory(String category) throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			ValidatingNewsCategory vnc = new ValidatingNewsCategory();
			boolean isValidCategory = vnc.isValid(category);

			if (!isValidCategory) {
				throw new SearchingError("This category is not supported from News API...");
			}

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/top-headlines?category=" + category.toLowerCase().trim()
							+ "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();
			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newsJSON);

			return res.getArticles();
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Searching top news by selected country.
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param country - Selected country
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchByCountry(String country) throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			ValidatingCountry vc = new ValidatingCountry();
			boolean isValidCountry = vc.isValid(country);

			if (!isValidCountry) {
				throw new SearchingError("This country is not supported from News API.");
			}

			List<SupportedISOCodes> codes = Arrays.asList(SupportedISOCodes.values());
			Optional<SupportedISOCodes> code = codes.stream()
					.filter(c -> c.getCountry().trim().equalsIgnoreCase(country.trim())).findFirst();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/top-headlines?country=" + code.get().getCountryCode()
							+ "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();
			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newsJSON);

			return res.getArticles();
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Search news by language
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param language - The language of articles
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchByLang(String language) throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			ValidatingLanguage vl = new ValidatingLanguage();
			boolean isValidLang = vl.isValid(language);

			if (!isValidLang)
				throw new SearchingError("This language is not supported from News API...");

			List<SupportedISOLanguages> langs = Arrays.asList(SupportedISOLanguages.values());
			Optional<SupportedISOLanguages> lang = langs.stream()
					.filter(l -> l.getLanguage().equalsIgnoreCase(language.trim())).findFirst();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/top-headlines?language=" + lang.get().getIsoCode()
							+ "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();
			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newsJSON);

			return res.getArticles();
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Search news by time period and article's title
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param dateFrom - the initial date
	 * @param dateTo   - the final date
	 * @param title    - the ariticle's title
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @throws DateError
	 * @return articles list
	 */
	public List<Article> searchByTimePeriod(LocalDate dateFrom, LocalDate dateTo, String title)
			throws SearchingError, DateError {
		try {
			if (!dateFrom.isBefore(dateTo))
				throw new DateError("Wrong date inputs: dateFrom is always before dateTo...");

			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/everything?q=" + title + "&from=" + dateFrom.toString()
							+ "&to=" + dateTo.toString()
							+ "&sortBy=popularityt&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newJSON = response.body();

			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newJSON);

			List<Article> articles = res.getArticles();

			if (articles.size() == 0)
				throw new SearchingError("Not found articles...");

			return articles;
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Search news by source
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param source - the source of news
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchBySource(String source) throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://newsapi.org/v2/top-headlines?sources=" + source.toLowerCase().trim()
							+ "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newsJSON = response.body();

			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newsJSON);
			List<Article> articles = res.getArticles();

			if (articles.size() == 0)
				throw new SearchingError("No articles found...");

			return articles;
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}

	/**
	 * Search news by a term.
	 * 
	 * @author Sotirios Karageorgopoulos
	 * @param term - the term which gives user
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SearchingError
	 * @return articles list
	 */
	public List<Article> searchByTerm(String term) throws SearchingError {
		try {
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(
							"https://newsapi.org/v2/everything?q=" + term + "&apiKey=e774591c5bef4863acbb636dcb9983ac"))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() >= 400) {
				throw new SearchingError("Error in News API response");
			}

			String newJSON = response.body();

			NewsResponseBuilder nrb = new NewsResponseBuilder();
			NewsResponse res = nrb.build(newJSON);
			List<Article> articles = res.getArticles();

			if (articles.size() == 0)
				throw new SearchingError("This term is not found...");

			return articles;
		} catch (IOException | InterruptedException e) {
			throw new SearchingError("Error in connection", e);
		}
	}
}
