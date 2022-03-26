package denisse.dbexam.util;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = 880590223310751L;

	private long code;
	private String status;
	private String message;
	private T result;

	public GenericResponse(String status) {
		this(status, -1L, null, null);
	}

	public GenericResponse(String status, long code, String message, T result) {
		this.status = status;
		if ("OK".equals(status)) {
			this.message = "OK";
			this.code = 200;

		} else if ("ERROR".equals(status)) {
			this.message = "ERROR";
			this.code = 500;

		}
		if (code > -1)
			this.code = code;

		if (message != null)
			this.message = message;

		this.result = result;
	}

}