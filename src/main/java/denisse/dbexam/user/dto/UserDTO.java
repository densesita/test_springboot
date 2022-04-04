package denisse.dbexam.user.dto;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Size(max=10,min=5,message="criteria not met, minimun 5 max 10")
	private String name;
	private String email;
//	@Size(max=12,min=6,message="criteria not met, minimun 6 max 12")
	private String password;
	private List<PhoneDTO> phones;

}
