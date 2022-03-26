package denisse.dbexam.user.dto;

import denisse.dbexam.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponse {
	private String id;
	private User user;
	private Boolean isActive;
}
