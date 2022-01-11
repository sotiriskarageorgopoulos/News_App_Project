package kar.sot.util.interfaces;

import java.io.IOException;
import java.util.List;

import kar.sot.error.SearchingError;
import kar.sot.util.Article;

public interface SearchingInterface<T> {
	public List<Article> search(T searchingTerm) throws IOException, InterruptedException, SearchingError;
}
