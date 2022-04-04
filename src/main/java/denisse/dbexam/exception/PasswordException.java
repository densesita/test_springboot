package denisse.dbexam.exception;

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
public class PasswordException extends RuntimeException {


	private static final long serialVersionUID = 1234234L;
	private String exceptionMessage;
	private HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	public PasswordException(String exceptionMessage, HttpStatus httpStatus) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.httpStatus = httpStatus;
	}


}
