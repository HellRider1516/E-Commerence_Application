package in.mahesh.Exception;

public class ProductServiceException extends RuntimeException{
	
	public String errorCode;

	public ProductServiceException(String errorCode , String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
