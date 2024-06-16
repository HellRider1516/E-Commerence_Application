package in.mahesh.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Order;
import in.mahesh.entity.OrderStatus;
import java.time.LocalDate;



public interface OrderRepo extends JpaRepository<Order, Integer> {
	

	public List<Order> findByStatus(OrderStatus status);
	
	public List<Order> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
