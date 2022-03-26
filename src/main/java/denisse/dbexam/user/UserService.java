package denisse.dbexam.user;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import denisse.dbexam.user.dto.CreateResponse;
import denisse.dbexam.user.dto.UserDTO;
import denisse.dbexam.user.model.User;
import denisse.dbexam.util.EmailException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	@Value("${email.regex}")
	private String VALID_EMAIL_ADDRESS_REGEX;
	
	
	public CreateResponse apiCreateUser(UserDTO user) throws Exception {
		
		// VALIDATIONS
		// 1. email not null
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			throw new EmailException(HttpStatus.BAD_REQUEST, "ERROR, email null or Empty");
		}
		// 2. email well format
		if (!validateEmail(user.getEmail())) {
			throw new EmailException(HttpStatus.BAD_REQUEST,"ERROR, email invalid ");
		}
		
		User userdb = userRepo.findByEmail(user.getEmail());
		if(userdb!=null ) {
			throw new Exception("Transaction unsuccessful, User with email "+user.getEmail()+" already exist. ");
		}
		
		User u = new User();
		u.setId(UUID.randomUUID().toString());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		Gson gson = new Gson();
		String ph = gson.toJson(user.getPhones());
		u.setPhones(ph);
		u.setCreated(new Date());
		u.setStatus("act");
		
		userRepo.save(u);
		
		CreateResponse res = new CreateResponse();
		res.setId(u.getId());
		res.setUser(u);
		res.setIsActive( u.getStatus().equals("act") );
		
		log.info("creacion de User ... "+user.getEmail());
		
		return res;
	}
	

	private boolean validateEmail(String emailStr) {
		Pattern VALID_REGEX = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	
	public User getUser(String email){
		return userRepo.findByEmail(email);
	}
}
