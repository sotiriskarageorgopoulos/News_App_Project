package kar.sot.error;

public class DateError extends Throwable {
	private String errorMessage;

	public DateError(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
