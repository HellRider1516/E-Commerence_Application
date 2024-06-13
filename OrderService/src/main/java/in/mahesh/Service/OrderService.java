package in.mahesh.Service;

import java.time.LocalDate;
import java.util.List;

import in.mahesh.Dto.OrderDto;

public interface OrderService {
	
	public List<OrderDto> addOrder(List<OrderDto> orderDto);
	
	public OrderDto updateOder(Integer orderId,OrderDto orderDto);
	
	public List<OrderDto> getAllOrders();
	
	public List<OrderDto> getOrderByUserId(Integer orderId);
	
	public List<OrderDto> getOrderByStatusAndData(LocalDate date , String status);

}
