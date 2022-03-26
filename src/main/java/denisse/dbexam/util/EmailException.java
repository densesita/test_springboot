package denisse.dbexam.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import com.google.common.base.Strings;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class EmailException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode = 404;
	private String exceptionMessage;
	private Object[] params;
	HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;

	public static EmailException generateResourceAccessException(String logCode, ResourceAccessException ex, Object... params) {
		EmailException customException = new EmailException();
		String exMessage = null;
		if(!Strings.isNullOrEmpty(exMessage)){
			customException.setExceptionMessage(exMessage);
		}
		customException.setParams(params);
		return customException;
	}
	
	public static EmailException generateHttpClientErrorException(String logCode, HttpClientErrorException ex, Object... params) {
		EmailException customException = new EmailException();
		String exMessage = null;
		customException.setExceptionMessage(exMessage);
		customException.setParams(params);
		return customException;
	}
	
	public static EmailException generateHttpClientErrorException(String logCode, HttpClientErrorException ex, boolean property, Object... params) {
		EmailException customException = new EmailException();
		String exMessage = null;
		if(!Strings.isNullOrEmpty(exMessage)){
			customException.setExceptionMessage(exMessage);
		}
		customException.setParams(params);
		return customException;
	}
	
	public static EmailException generateHttpServerErrorException(String logCode, HttpServerErrorException ex, Object... params) {
		EmailException customException = new EmailException();
		String exMessage = null;
		if(exMessage==null||exMessage.isEmpty()) {
			exMessage =ex.getResponseBodyAsString(); 
		}
		if(!Strings.isNullOrEmpty(exMessage)){
			customException.setExceptionMessage(exMessage);
		}
		customException.setParams(params);
		return customException;
	}

	
	public static EmailException generateRestClientException(String logCode, RestClientException ex, Object... params) {
		EmailException customException = new EmailException();
		return customException;
	}
	
	public EmailException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public EmailException(String exceptionMessage, String logMessage, Object... params) {
		super(exceptionMessage);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public EmailException(String exceptionMessage, String logMessage) {
		super(exceptionMessage);
	}

	public EmailException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public EmailException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public EmailException(Throwable throwable) {
		super(throwable);
	}

	public EmailException(String message, Throwable throwable) {
		super(message, throwable);
	}


}
