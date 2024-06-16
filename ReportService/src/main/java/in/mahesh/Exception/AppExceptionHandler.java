package in.mahesh.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler   {
	
	@ExceptionHandler(value = ReportServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ReportServiceException rse){
		ErrorResponse err=new ErrorResponse();
		err.setErrorCode(rse.getErrorCode());
		err.setMessage(rse.getMessage());
		
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
