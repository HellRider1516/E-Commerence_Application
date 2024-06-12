package in.mahesh.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = AuthServiceException.class)
	public ResponseEntity<ExceptionResponse> handleAuthException(AuthServiceException ae){
		
		ExceptionResponse er = new ExceptionResponse();
		
		er.setMessage(ae.getMessage());
		er.setErrorCode(ae.getErrorCode());
		
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
