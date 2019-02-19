package astralplane.exception;

/*
 * Generic 404 exception handler
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8956565884420646684L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
