package in.mahesh.Service;

import java.time.LocalDate;
import java.util.List;

import in.mahesh.Dto.OrderDto;
import in.mahesh.entity.OrderStatus;

public interface ReportService {
	
	public List<OrderDto> getAllOrders();
	
	public List<OrderDto> orderByStatus(OrderStatus status);
	
	public List<OrderDto> getOrdersBetweenDate(LocalDate startDate , LocalDate endDate);

}
