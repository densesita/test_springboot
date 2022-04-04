package denisse.dbexam.exception;

import org.springframework.http.HttpStatus;

public class EmailException extends RuntimeException  {

	private static final long serialVersionUID = 1234234L;
	private String exceptionMessage;
	private HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	
	public EmailException(String exceptionMessage, HttpStatus httpStatus) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.httpStatus = httpStatus;
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


}
