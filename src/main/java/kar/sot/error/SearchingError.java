package kar.sot.error;

public class SearchingError extends Exception {

	public SearchingError() {
		super();
	}

	public SearchingError(String message) {
		super(message);
	}

	public SearchingError(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchingError(Throwable cause) {
		super(cause);
	}

	protected SearchingError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
