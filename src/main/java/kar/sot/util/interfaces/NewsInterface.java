package kar.sot.util.interfaces;

import java.util.List;

import kar.sot.error.DateError;
import kar.sot.error.SearchingError;
import kar.sot.util.Article;

public interface NewsInterface<T,V> {
	public List<Article> searchByUserCountry() throws SearchingError;
	public List<Article> searchByCountryAndCategory(T category) throws SearchingError;
	public List<Article> searchByCategory(T category) throws SearchingError;
	public List<Article> searchByCountry(T country) throws SearchingError;
	public List<Article> searchByLang(T language) throws SearchingError;
	public List<Article> searchByTimePeriod(V dateFrom, V dateTo, T title) throws SearchingError, DateError;
	public List<Article> searchBySource(T source) throws SearchingError;
	public List<Article> searchByTerm(T term) throws SearchingError;
	
}
