package in.mahesh.Service;

import in.mahesh.Dto.CartDto;

public interface CartService {
	
	public CartDto addCart(CartDto cartDto);
	
	public CartDto updateCartQuantityById(Integer cartId);
	
	public CartDto getCartByUserId(Integer userId);

	public CartDto deleteCartById(Integer cartId);
	
	

}
