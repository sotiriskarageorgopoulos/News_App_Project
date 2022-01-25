package kar.sot;

import kar.sot.services.NewsServiceAPI;

public class NewsAPI {
	public static NewsServiceAPI getNewsService() {
		return new NewsServiceAPI();
	}
}

