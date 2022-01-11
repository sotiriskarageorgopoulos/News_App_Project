package kar.sot.util.interfaces;

import java.io.IOException;
import java.util.List;

import kar.sot.util.Article;
import kar.sot.error.SearchingError;

public interface SearchingCountryInterface {
	public List<Article> search() throws IOException, InterruptedException, SearchingError;
}
