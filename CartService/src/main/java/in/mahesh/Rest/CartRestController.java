package in.mahesh.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Dto.CartDto;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.CartServiceImp;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartRestController {
	
	@Autowired
	private CartServiceImp service;
	
	@PostMapping("/cart")
	public ResponseEntity<ApiResponse<CartDto>> addCart(@RequestBody CartDto cartDto){
		CartDto savedCart = service.addCart(cartDto);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		if(savedCart  != null) {
			resp.setData(savedCart);
			resp.setMessage("Added to cart sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("Error to Add to cart");
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping("/cart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> updateCart(@PathVariable("cartId") Integer cartId){
		CartDto updateCartQuantityById = service.updateCartQuantityById(cartId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		if(updateCartQuantityById != null) {
			resp.setData(updateCartQuantityById);
			resp.setMessage("Cart Updated Sucessfully");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("Error to Updated into Cart");
			resp.setStatusCode(5000);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<ApiResponse<CartDto>> getCartByUsingUserId(@PathVariable("userId") Integer userId){
		CartDto cartByUserId = service.getCartByUserId(userId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		if(cartByUserId != null) {
			resp.setData(cartByUserId);
			resp.setMessage("Retired Cart by Using user Id");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("Error to Retired Cart by Using user Id");
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> deleteCartById(@PathVariable("cartId") Integer cartId){
		CartDto deleteCartById = service.deleteCartById(cartId);
		ApiResponse<CartDto> resp = new ApiResponse<>();
		if(deleteCartById != null) {
			resp.setData(deleteCartById);
			resp.setMessage("Deleted cart by Id");
			resp.setStatusCode(200);
		}else {
			resp.setMessage("Error to Deleted the cart");
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CartDto>>(resp, HttpStatus.OK);
	}
	
	
	
	
	

}
