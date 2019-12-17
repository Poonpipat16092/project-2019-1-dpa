package exception;

public class BarrierOnException extends Exception {
	@Override
	public String getMessage() {
		return "The player already has a barrier";
	}
}
