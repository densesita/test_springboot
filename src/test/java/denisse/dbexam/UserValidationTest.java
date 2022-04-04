package denisse.dbexam;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import denisse.dbexam.service.UserService;
import denisse.dbexam.user.dto.UserDTO;

@SpringBootTest
class UserValidationTest {

	@Autowired
	private UserService userService;

	@Test
	void testValidPassword() {
		String pass = "ASD345345";
		Assert.isTrue(userService.validatePassword(pass));
	}

	
	@Test
	void testInvalidPassword() {
		String pass = "123";
		Assert.isTrue(!userService.validatePassword(pass));
	}
	
	@Test
	void testRequiredFields() {
		try {
			UserDTO user = new UserDTO();
			user.setEmail("sahara");
			userService.apiCreateUser(user);
		} catch (Exception e) {
			org.junit.jupiter.api.Assertions.assertTrue(true);
			return;
		}
		fail("Required fields fail ");
	}
}
