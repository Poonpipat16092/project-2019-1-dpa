package exception;

public class MaxHealthException extends Exception {
	@Override
	public String getMessage() {
		return "The player is already at max health";
	}

}
