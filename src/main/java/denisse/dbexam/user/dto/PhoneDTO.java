package denisse.dbexam.user.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 4322255L;

	private String number;
	private String cityCode;
	private String countryCode;

}
