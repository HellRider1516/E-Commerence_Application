package in.mahesh.Rest;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.UserServiceImp;
import in.mahesh.constants.AppConstants;
import in.mahesh.entity.User;
import in.mahesh.properties.AppProperties;

@RestController
public class UserRestController {
	
	@Autowired
	private UserServiceImp service;
	
	@Autowired
	private AppProperties props;
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<User>> createUser(@RequestParam("user") String userJson,
			@RequestParam("file") MultipartFile file) throws Exception {

		log.info("user registaration process started");
		ApiResponse<User> response = new ApiResponse<>();
		Map<String, String> message = props.getMessage();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);

		User addedUser = service.addUser(user, file);

		if (addedUser != null) {
			response.setStatus(201);
			response.setMessage(message.get(AppConstants.USER_REG_SUCC));
			response.setData(addedUser);
		} else {
			response.setStatus(500);
			response.setMessage(message.get(AppConstants.USER_REG_ERR));
		}
		log.info("user registaration process completed");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<User>> login(@RequestBody User user) {

		log.info("user login process started");

		ApiResponse<User> response = new ApiResponse<>();

		User loggedInUser = service.userLogin(user);
		Map<String, String> message = props.getMessage();

		if (loggedInUser != null) {
			response.setStatus(200);
			response.setMessage(message.get(AppConstants.LOGIN_SUCC));
			response.setData(loggedInUser);
		} else {
			log.error("user login failed");
			response.setStatus(500);
			response.setMessage(message.get(AppConstants.LOGIN_ERR));
		}
		log.info("user login process completed");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
