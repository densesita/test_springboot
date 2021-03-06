package denisse.dbexam.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import denisse.dbexam.exception.EmailException;
import denisse.dbexam.service.UserService;
import denisse.dbexam.user.dto.CreateResponse;
import denisse.dbexam.user.dto.UserDTO;
import denisse.dbexam.util.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Api(value = "User")
@CrossOrigin("*")
@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;

	//
	//
	@ApiOperation(value = "Crear User with phone list.", //
			notes = "Creacion de usuarios y telefonos a la base con validaciones de mail y de password.")
	@RequestMapping(value = "/api/v1/users", method = RequestMethod.POST, //
			consumes = "application/json", //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<GenericResponse<CreateResponse>> createUser(//
			@Valid @RequestBody UserDTO user //
			, HttpServletRequest request)  throws Exception{
		//
		long startTransactionTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		String transactionId = UUID.randomUUID().toString();
		GenericResponse<CreateResponse> response = new GenericResponse<>();

		CreateResponse res = userService.apiCreateUser(user);
		response.setResult(res);
		headers.add("transaction_id", transactionId);
		headers.add("transaction_time", "" + (System.currentTimeMillis() - startTransactionTime));
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
		//
	}

}
