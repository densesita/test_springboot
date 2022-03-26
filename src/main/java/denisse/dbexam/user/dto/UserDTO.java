package denisse.dbexam.user.dto;

import java.util.List;

import denisse.dbexam.user.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private String name;

	private String email;

	private String password;
	
	private List<Phone> phones;
	

}
