package in.mahesh.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.mahesh.Repo.UserRepo;
import in.mahesh.entity.User;
@Service
public class UserServiceImp implements UserService {
	
	private UserRepo uRepo;

	@Override
	public User addUser(User user, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
