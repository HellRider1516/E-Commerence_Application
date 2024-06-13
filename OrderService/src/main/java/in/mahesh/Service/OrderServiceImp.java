package in.mahesh.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mahesh.Dto.OrderDto;
import in.mahesh.Mapper.OrderMapper;
import in.mahesh.Repo.OrderRepo;
import in.mahesh.entity.Order;
@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderRepo repo;

	@Override
	public List<OrderDto> addOrder(List<OrderDto> orderDto) {
		List<Order> orderEntity = orderDto.stream().map(OrderMapper :: convertToEntity).collect(Collectors.toList());
		List<Order> savedOrders = repo.saveAll(orderEntity);
		if(savedOrders != null) {
			return savedOrders.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
		}
		
		return null;
	}

	@Override
	public OrderDto updateOder(Integer orderId, OrderDto orderDto) {
		Optional<Order> byId = repo.findById(orderId);
		if(byId.isPresent()) {
			Order updateOrder = OrderMapper.convertToEntity(orderDto);
			Order upadtedOrder = repo.save(updateOrder);
			return  OrderMapper.convertToDto(upadtedOrder);
		}
		return null;
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> list = repo.findAll();
		if( list != null) {
			return list.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<OrderDto> getOrderByUserId(Integer userId) {
		List<Order> byUserId = repo.findByUserId(userId);
		if(byUserId != null) {
			
			return byUserId.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList()) ;
		}
		return null;
	}

	@Override
	public List<OrderDto> getOrderByStatusAndData(LocalDate date, String status) {
		List<Order> byOrderStatusAndOrderDate = repo.findByOrderStatusAndOrderDate(status, date);
		if(byOrderStatusAndOrderDate != null) {
			return byOrderStatusAndOrderDate.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
		}
		return null;
	}

}
