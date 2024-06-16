package in.mahesh.Mapper;

import org.modelmapper.ModelMapper;

import in.mahesh.Dto.OrderDto;
import in.mahesh.entity.Order;

public class OrderMapper {
	
	public static final ModelMapper mapper = new ModelMapper();
	
	public static OrderDto convertToDto(Order order) {
		return mapper.map(order, OrderDto.class);
	}
	
	
	public static Order convertToDto(OrderDto orderDto) {
		return mapper.map(orderDto, Order.class);
	}

}
