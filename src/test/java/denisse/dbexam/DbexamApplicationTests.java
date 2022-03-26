package denisse.dbexam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import denisse.dbexam.user.UserService;
import denisse.dbexam.user.dto.UserDTO;
import denisse.dbexam.user.model.User;
import denisse.dbexam.util.EmailException;

@SpringBootTest
class DbexamApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void testEmailError() {
		try {
			UserDTO user = new UserDTO();
			user.setEmail("sahara");
			userService.apiCreateUser(user);
		} catch (EmailException e) {
			org.junit.jupiter.api.Assertions.assertTrue(true);
			return;
		} catch (Exception e) {
			org.junit.jupiter.api.Assertions.assertTrue(true);
			return;
		}
		fail("Validation Email  fail ");
	}

	@Test
	void testEmailExito() {
		try {
			UserDTO user = new UserDTO();
			user.setEmail("sahara@gmail.com");
			user.setName("Sahara");
			user.setPassword("password");
			userService.apiCreateUser(user);
			org.junit.jupiter.api.Assertions.assertTrue(true);
		} catch (EmailException e) {
			fail("Email error");

		} catch (Exception e) {
			fail(" error");

		}
	}

	@Test
	void testCrearUser() {
		try {
			UserDTO user = new UserDTO();
			user.setEmail("creaUser@gmail.com");
			user.setName("User01");
			user.setPassword("password");
			userService.apiCreateUser(user);
			//
			User t = userService.getUser(user.getEmail());
			org.junit.jupiter.api.Assertions.assertTrue(t != null);
		} catch (EmailException e) {
			fail("Email error");

		} catch (Exception e) {
			fail(" error");

		}
	}



}
