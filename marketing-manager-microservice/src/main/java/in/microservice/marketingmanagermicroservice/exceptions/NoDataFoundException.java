package in.microservice.marketingmanagermicroservice.exceptions;

public class NoDataFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255889102904847181L;
	
	public NoDataFoundException() {
		super();
	}
	public NoDataFoundException(String message) {
		super(message);
	}
}
