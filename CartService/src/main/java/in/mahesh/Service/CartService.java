package in.mahesh.Service;

import in.mahesh.Dto.CartDto;

public interface CartService {
	
	public CartDto addCart(CartDto cartDto);
	
	public CartDto updateCartQuantityById(CartDto cartDto);
	
	public CartDto getCartByUserId(Integer userId);

	public void deleteCartById(Integer cartId);
	
	

}
