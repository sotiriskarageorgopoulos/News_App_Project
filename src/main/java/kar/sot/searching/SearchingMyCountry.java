package kar.sot.searching;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.GsonBuilder;

import kar.sot.util.Country;

public class SearchingMyCountry {

	SearchingMyCountry() {
	}

	/**
	 * Find user's country
	 * @author Sotirios Karageorgopoulos 
	 * @return the user's country.
	 * @throws IOException
	 * @throws InterruptedException
	 * @return user's country
	 */
	Country searchMyCountry() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest requestCountry = HttpRequest.newBuilder().uri(URI.create("http://ip-api.com/json/?fields=61439"))
				.build();

		HttpResponse<String> responseCountry = client.send(requestCountry, BodyHandlers.ofString());
		String countryJSON = responseCountry.body();

		return new GsonBuilder().create().fromJson(countryJSON, Country.class);
	}
}
