package in.mahesh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mahesh.Dto.CartDto;
import in.mahesh.Repo.CartRepo;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepo repo;

	@Override
	public CartDto addCart(CartDto cartDto) {
		
		return null;
	}

	@Override
	public CartDto updateCartQuantityById(CartDto cartDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDto getCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCartById(Integer cartId) {
		// TODO Auto-generated method stub

	}

}
