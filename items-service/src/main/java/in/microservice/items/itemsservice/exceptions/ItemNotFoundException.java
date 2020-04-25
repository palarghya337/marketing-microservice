package in.microservice.items.itemsservice.exceptions;

public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479939978923152681L;
	public ItemNotFoundException() {
		super();
	}
	public ItemNotFoundException(String message) {
		super(message);
	}

}
