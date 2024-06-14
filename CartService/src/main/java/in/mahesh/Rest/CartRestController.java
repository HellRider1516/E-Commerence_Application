package in.mahesh.Rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Constants.AppConstants;
import in.mahesh.Dto.CartDto;
import in.mahesh.Properties.AppProperties;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.CartServiceImp;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartRestController {
	
	@Autowired
	private CartServiceImp service;
	
	@Autowired
	private AppProperties props;
	
	@PostMapping("/cart")
	public ResponseEntity<ApiResponse<CartDto>> addCart(@RequestBody CartDto cartDto){
		CartDto savedCart = service.addCart(cartDto);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(savedCart  != null) {
			resp.setData(savedCart);
			resp.setMessage(message.get(AppConstants.CART_ADD_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.CART_ADD_ERR));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping("/cart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> updateCart(@PathVariable("cartId") Integer cartId){
		CartDto updateCartQuantityById = service.updateCartQuantityById(cartId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(updateCartQuantityById != null) {
			resp.setData(updateCartQuantityById);
			resp.setMessage(message.get(AppConstants.CART_UPDATE_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.CART_UPDATE_ERR));
			resp.setStatusCode(5000);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<ApiResponse<CartDto>> getCartByUsingUserId(@PathVariable("userId") Integer userId){
		CartDto cartByUserId = service.getCartByUserId(userId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(cartByUserId != null) {
			resp.setData(cartByUserId);
			resp.setMessage(message.get(AppConstants.CART_RET_BYUSINGID_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.CART_RET_BYUSINGID_ERR));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> deleteCartById(@PathVariable("cartId") Integer cartId){
		CartDto deleteCartById = service.deleteCartById(cartId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(deleteCartById != null) {
			resp.setData(deleteCartById);
			resp.setMessage(message.get(AppConstants.CART_DEL_SUCC));
			resp.setStatusCode(200);
		}else {
			resp.setMessage(message.get(AppConstants.CART_DEL_ERR));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	
	
	

}
