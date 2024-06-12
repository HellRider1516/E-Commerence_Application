package in.mahesh.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.mahesh.Dto.ProductsDto;

public interface ProductsService {
	
	public ProductsDto addProduct(ProductsDto productsDto , MultipartFile file);
	
	public ProductsDto updateProduct(Integer productId , ProductsDto productsDto , MultipartFile file);
	
	public List<ProductsDto> getAllProducts();
	
	public ProductsDto getProductById(Integer productId );
	
	public ProductsDto delProductById(Integer productId);
	
	public boolean updateStock(Integer productId , Integer quantity);
	
	
	
	

}
