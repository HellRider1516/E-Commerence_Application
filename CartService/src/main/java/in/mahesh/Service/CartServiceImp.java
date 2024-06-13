package in.mahesh.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mahesh.Dto.CartDto;
import in.mahesh.Mapper.CartMappper;
import in.mahesh.Repo.CartRepo;
import in.mahesh.entity.Cart;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepo repo;

	@Override
	public CartDto addCart(CartDto cartDto) {
		Cart convertToEntity = CartMappper.convertToEntity(cartDto);
		Cart cartSaved = repo.save(convertToEntity);
		if(convertToEntity != null) {
			return CartMappper.convertToDto(cartSaved);
		}
		return null;
	}

	@Override
	public CartDto updateCartQuantityById(Integer cartId) {
		Optional<Cart> byId = repo.findById(cartId);
		if(byId.isPresent()) {
			Cart cart = byId.get();
			return CartMappper.convertToDto(cart);
			
		}
		return null;
	}

	@Override
	public CartDto getCartByUserId(Integer userId) {
		Optional<Cart> byId = repo.findById(userId);
		if(byId.isPresent()) {
			Cart cart = byId.get();
			return CartMappper.convertToDto(cart);
		}
		return null;
	}

	@Override
	public CartDto deleteCartById(Integer cartId) {
		Optional<Cart> byId = repo.findById(cartId);
		if(byId.isPresent()) {
			Cart cart = byId.get();
			repo.deleteById(cartId);
			return CartMappper.convertToDto(cart);
		}
		return null;
		

	}

}
