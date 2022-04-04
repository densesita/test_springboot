package denisse.dbexam.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import denisse.dbexam.exception.EmailException;
import denisse.dbexam.exception.PasswordException;
import denisse.dbexam.model.User;
import denisse.dbexam.repo.UserRepo;
import denisse.dbexam.user.dto.CreateResponse;
import denisse.dbexam.user.dto.UserDTO;
import denisse.dbexam.util.CommonsUtils;
import denisse.dbexam.util.Constant;
import denisse.dbexam.util.StatusEnum;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	PhoneService phoneService;

	@Value("${email.regex}")
	private String VALID_EMAIL_ADDRESS_REGEX;

	@Value("${password.regex}")
	private String VALID_PASSWORD_REGEX;

	/**
	 * @param user
	 * @return
	 * @throws EmailException
	 * @throws Exception
	 */
	public CreateResponse apiCreateUser(UserDTO user) throws Exception {
		CreateResponse res = new CreateResponse();
		// 1. email not null
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			throw new EmailException("ERROR, email null or Empty", HttpStatus.BAD_REQUEST);
		}

		// 2. email well format
		if (!validateEmail(user.getEmail())) {
			throw new EmailException("ERROR, email invalid ", HttpStatus.BAD_REQUEST);
		}

		// validate user not exist.
		User userdb = userRepo.findByEmail(user.getEmail());
		if (userdb != null) {
			throw new Exception("Transaction unsuccessful, User with email " + user.getEmail() + " already exist. ");
		}

		// validate password policy
		if (!validatePassword(user.getPassword())) {
			throw new PasswordException("ERROR, password  invalid. " + Constant.TEXT_PASSWORD_POLICY, HttpStatus.OK);
		}

		User userDB = new User();
		userDB.setId(CommonsUtils.generateUUID());
		userDB.setName(user.getName());
		userDB.setEmail(user.getEmail());
		userDB.setPassword(user.getPassword());
		userDB.setCreated(new Date());
		userDB.setStatus(StatusEnum.OPEN);
		userRepo.save(userDB);

		// GUARDANDO LOS PHONES
		phoneService.persistPhoneList(user.getPhones(), userDB);

		res.setId(userDB.getId());
		res.setUser(userDB);
		res.setIsActive(userDB.getStatus().equals(StatusEnum.OPEN));

		log.info("User Creation successful " + user.getEmail());
		return res;
	}

	
	
	
	
	/**
	 * 
	 * @param strPassword
	 * @return
	 */
	public boolean validatePassword(String strPassword) {
//		String reg = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
//		System.out.println(reg);
		System.out.println(VALID_PASSWORD_REGEX);
		Pattern VALID_REGEX = Pattern.compile(VALID_PASSWORD_REGEX);
		Matcher matcher = VALID_REGEX.matcher(strPassword);
		boolean res = matcher.matches();
		return res;
	}
	
	/**
	 * 
	 * @param emailStr
	 * @return
	 */
	public boolean validateEmail(String emailStr) {
		Pattern VALID_REGEX = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_REGEX.matcher(emailStr);
		return matcher.find();
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public User getUser(String email) {
		return userRepo.findByEmail(email);
	}
}
