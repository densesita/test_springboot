package denisse.dbexam;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import denisse.dbexam.model.User;
import denisse.dbexam.service.UserService;
import denisse.dbexam.user.dto.UserDTO;

@SpringBootTest
class DbexamApplicationTests {

	@Autowired
	private UserService userService;

	@SuppressWarnings("deprecation")
	@Test
	void testEmailFormatError() {
		String email = "sahara";
		boolean result = userService.validateEmail(email); 
		Assert.isTrue(!result);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testEmailFormatExito() {
		String email = "sahara@gmail.com";
		Assert.isTrue(userService.validateEmail(email));

	}

	@Test
	void testCrearUser() {
		try {
			UserDTO user = new UserDTO();
			user.setEmail("creaUser@gmail.com");
			user.setName("User01");
			user.setPassword("password1234");
			userService.apiCreateUser(user);
			//
			User t = userService.getUser(user.getEmail());
			org.junit.jupiter.api.Assertions.assertTrue(t != null);
		}catch (Exception e) {
			fail(" error");

		}
	}



}
