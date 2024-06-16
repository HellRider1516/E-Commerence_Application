package in.mahesh.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import in.mahesh.Dto.OrderDto;
import in.mahesh.Mapper.OrderMapper;
import in.mahesh.Repo.OrderRepo;
import in.mahesh.entity.Order;
import in.mahesh.entity.OrderStatus;

public class ReportServiceImp implements ReportService {
	
	@Autowired
	private OrderRepo repo;

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> list = repo.findAll();
		return list.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> orderByStatus(OrderStatus status) {
		List<Order> byStatus = repo.findByStatus(status);
		return byStatus.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
	}

	@Override
	public List<OrderDto> getOrdersBetweenDate(LocalDate startDate, LocalDate endDate) {
		List<Order> byStartDateAndEndDate = repo.findByStartDateAndEndDate(startDate, endDate);
		return byStartDateAndEndDate.stream().map(OrderMapper :: convertToDto).collect(Collectors.toList());
	}

}
