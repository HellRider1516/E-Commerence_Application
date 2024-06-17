package in.mahesh.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.mahesh.entity.User;

public interface UserService {
	
	public User addUser(User user , MultipartFile file) throws IOException;
	
	public User userLogin(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(Integer userId);
	
	public User delUserById(Integer userId);
	
	

}
