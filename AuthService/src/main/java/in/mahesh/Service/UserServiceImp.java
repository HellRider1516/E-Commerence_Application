package in.mahesh.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.mahesh.Repo.UserRepo;
import in.mahesh.Utils.FileUtils;
import in.mahesh.entity.User;
@Service
public class UserServiceImp implements UserService {
	
	
	
	
	public UserServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserRepo uRepo;
	
	private PasswordEncoder passwordEncoder;	

	private AuthenticationManager authManager;
	
	@Autowired
	public UserServiceImp(PasswordEncoder passwordEncoder, AuthenticationManager authManager) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
	}

	@Override
	public User addUser(User user, MultipartFile file) throws IOException {
		User u = uRepo.findByEmail(user.getEmail());
		if(u == null) {
			String fileName = FileUtils.saveFiles(file.getName(), file);
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			user.setUserPic(fileName);
			return uRepo.save(user);
			
		}
		return u;
	}

	@Override
	public User userLogin(User user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		Authentication authenticate = null ;
		try {
			 Authentication authenticate2 = authManager.authenticate(token);
			if(authenticate2.isAuthenticated()) {
				return uRepo.findByEmail(user.getEmail());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return uRepo.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		return uRepo.findById(userId).orElseThrow();
		
	}

	@Override
	public User delUserById(Integer userId) {
		User user = uRepo.findById(userId).orElseThrow();
		if(user != null) {
			uRepo.deleteById(userId);
			return user;
		}
		return null;
	}

}
