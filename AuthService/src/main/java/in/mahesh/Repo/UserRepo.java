package in.mahesh.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User  findByEmail(String email);

}
