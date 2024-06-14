package in.mahesh.Rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Constants.AppConstants;
import in.mahesh.Dto.OrderDto;
import in.mahesh.Properties.AppProperties;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.OrderServiceImp;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderRest {
	
	@Autowired
	private OrderServiceImp service;
	
	@Autowired
	private AppProperties props;
	
	@PostMapping("/orders")
	public ResponseEntity<ApiResponse<List<OrderDto>>> addOrders(@RequestBody List<OrderDto> orderDto){
		List<OrderDto> savedOrder = service.addOrder(orderDto);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(savedOrder != null) {
			resp.setData(savedOrder);
			resp.setMessage(message.get(AppConstants.ORDER_SAVED_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.ORDER_SAVED_ERR));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp,HttpStatus.CREATED);
	}
	
	@PutMapping("orders/{orderId}")
	public ResponseEntity<ApiResponse<OrderDto>> updateOrder(@RequestBody OrderDto orderDto , @PathVariable("orderId") Integer orderId){
		OrderDto updateOder = service.updateOder(orderId, orderDto);
		ApiResponse<OrderDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(updateOder != null) {
			resp.setData(updateOder);
			resp.setMessage(message.get(AppConstants.ORDER_UPDATE_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.ORDER_UPDATE_ERR));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<OrderDto>>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/orders")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getAllOrders(){
		List<OrderDto> allOrders = service.getAllOrders();
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(allOrders != null) {
			resp.setData(allOrders);
			resp.setMessage(message.get(AppConstants.ORDER_RET_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.ORDER_RET_ERR));
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/order/{userId}")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getOrderByUsingUserId(@PathVariable Integer userId){
		List<OrderDto> orderByUserId = service.getOrderByUserId(userId);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(orderByUserId != null) {
			resp.setData(orderByUserId);
			resp.setMessage(message.get(AppConstants.ORDER_RET_BYUSERID_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.ORDER_RET_BYUSERID_ERR));
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/orders/{status}/{date}")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getOrderByStatusAndDate(@PathVariable String status ,@PathVariable LocalDate date){
		List<OrderDto> orderByStatusAndData = service.getOrderByStatusAndData(date, status);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(orderByStatusAndData != null) {
			resp.setData(orderByStatusAndData);
			resp.setMessage(message.get(AppConstants.ORDER_RET_BYSTAUSANDTIME_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.ORDER_RET_BYSTAUSANDTIME_ERR));
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
	}
	
	
	

}






























