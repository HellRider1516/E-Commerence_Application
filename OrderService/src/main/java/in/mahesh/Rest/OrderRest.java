package in.mahesh.Rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Dto.OrderDto;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.OrderServiceImp;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderRest {
	
	@Autowired
	private OrderServiceImp service;
	
	@PostMapping("/orders")
	public ResponseEntity<ApiResponse<List<OrderDto>>> addOrders(@RequestBody List<OrderDto> orderDto){
		List<OrderDto> savedOrder = service.addOrder(orderDto);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		if(savedOrder != null) {
			resp.setData(savedOrder);
			resp.setMessage("oreders saved sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("saved error ");
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp,HttpStatus.CREATED);
	}
	
	@PutMapping("orders/{orderId}")
	public ResponseEntity<ApiResponse<OrderDto>> updateOrder(@RequestBody OrderDto orderDto , @PathVariable("orderId") Integer orderId){
		OrderDto updateOder = service.updateOder(orderId, orderDto);
		ApiResponse<OrderDto> resp = new ApiResponse<>();
		if(updateOder != null) {
			resp.setData(updateOder);
			resp.setMessage("oreders Updated sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("oreders Updated Error");
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<OrderDto>>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/orders")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getAllOrders(){
		List<OrderDto> allOrders = service.getAllOrders();
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		if(allOrders != null) {
			resp.setData(allOrders);
			resp.setMessage("oreders Retired sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("oreders Retired Error");
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/order/{userId}")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getOrderByUsingUserId(@PathVariable Integer userId){
		List<OrderDto> orderByUserId = service.getOrderByUserId(userId);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		if(orderByUserId != null) {
			resp.setData(orderByUserId);
			resp.setMessage("oreder Retired by using user Id sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("oreder Retired by using user Id error");
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/orders/{status}/{date}")
	public ResponseEntity<ApiResponse<List<OrderDto>>> getOrderByStatusAndDate(@PathVariable String status ,@PathVariable LocalDate date){
		List<OrderDto> orderByStatusAndData = service.getOrderByStatusAndData(date, status);
		ApiResponse<List<OrderDto>> resp = new ApiResponse<>();
		if(orderByStatusAndData != null) {
			resp.setData(orderByStatusAndData);
			resp.setMessage("oreder Retired by using Status And Data sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("oreder Retired by using Status And Data error");
			resp.setStatusCode(500);
		}
		
		return new ResponseEntity<ApiResponse<List<OrderDto>>>(resp, HttpStatus.OK);
	}
	
	
	

}






























