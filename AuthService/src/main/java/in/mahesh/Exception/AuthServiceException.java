package in.mahesh.Exception;

public class AuthServiceException extends RuntimeException{
	
	private String errorCode;
	
	

	public AuthServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AuthServiceException(String message ,String errorCode ) {
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
