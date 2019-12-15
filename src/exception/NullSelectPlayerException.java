package exception;

public class NullSelectPlayerException extends Exception {
	@Override
	public String getMessage() {
		return "No Characted selected";
	}
}
