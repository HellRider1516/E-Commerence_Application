package in.mahesh.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Order;
import java.util.List;
import java.time.LocalDate;



public interface OrderRepo extends JpaRepository<Order, Integer>{
	
	public List<Order> findByUserId(Integer userId);
	
	public List<Order> findByOrderStatusAndOrderDate(String orderStatus, LocalDate orderDate);

}
