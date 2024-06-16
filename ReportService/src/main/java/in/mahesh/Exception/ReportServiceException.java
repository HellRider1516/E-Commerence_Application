package in.mahesh.Exception;

public class ReportServiceException extends RuntimeException {
	
	private String errorCode;
	private String message;
	
	

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ReportServiceException (String errorCode , String message) {
		super();
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
