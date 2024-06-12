package in.mahesh.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
