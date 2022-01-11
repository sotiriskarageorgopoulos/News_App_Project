package kar.sot.util.interfaces;

import java.io.IOException;
import java.util.List;
import kar.sot.util.Article;
import kar.sot.error.DateError;
import kar.sot.error.SearchingError;

public interface SearchingByDateInterface<T, V> {
	public List<Article> search(T d1, T d2, V title)
			throws IOException, InterruptedException, SearchingError, DateError;
}
