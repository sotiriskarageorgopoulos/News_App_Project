package kar.sot.error;

public class SearchingError extends Throwable {
	private String errorMessage;

	public SearchingError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
