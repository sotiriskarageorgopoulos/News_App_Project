package kar.sot.error;

public class DateError extends Throwable {
	public DateError() {
		super();
	}

	public DateError(String message) {
		super(message);
	}

	public DateError(String message, Throwable cause) {
		super(message, cause);
	}

	public DateError(Throwable cause) {
		super(cause);
	}

	protected DateError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
