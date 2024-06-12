package in.mahesh.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceException pse){
		ErrorResponse err=new ErrorResponse();
		err.setErrorCode(pse.getErrorCode());
		err.setMessage(pse.getMessage());
		
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
