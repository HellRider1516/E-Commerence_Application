package in.mahesh.Mapper;

import org.modelmapper.ModelMapper;

import in.mahesh.Dto.CartDto;
import in.mahesh.entity.Cart;

public class CartMappper {
	

	public static final ModelMapper mapper =new ModelMapper();
	
	public static CartDto convertToDto(Cart cart) {
		
		return mapper.map(cart, CartDto.class);
		
	}
	
	
	public static Cart convertToEntity(CartDto cartDto) {
		
		return mapper.map(cartDto , Cart.class);
		
	}
}
