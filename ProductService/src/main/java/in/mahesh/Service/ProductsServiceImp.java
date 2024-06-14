package in.mahesh.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.mahesh.Dto.ProductsDto;
import in.mahesh.Exception.ProductServiceException;
import in.mahesh.Mapper.ProductsMapper;
import in.mahesh.Repo.ProductRepo;
import in.mahesh.entity.Products;

@Service
public class ProductsServiceImp implements ProductsService {
	
	@Autowired
	private ProductRepo pRepo;

	@Override
	public ProductsDto addProduct(ProductsDto productsDto, MultipartFile file) {
		Products convertToEntity = ProductsMapper.convertToEntity(productsDto);
		Products savedProduct = pRepo.save(convertToEntity);
		if(savedProduct.getProductId()!=null) {
			return ProductsMapper.convertToDto(savedProduct);
		}
		return null;
	}

	@Override
	public ProductsDto updateProduct(Integer productId, ProductsDto productsDto, MultipartFile file) {
		Optional<Products> byId = pRepo.findById(productId);
		if(byId.isPresent()) {
			Products product = byId.get();
			BeanUtils.copyProperties(productsDto, product);
			Products productUpdated = pRepo.save(product);
			return ProductsMapper.convertToDto(productUpdated);
		}

		return null;
	}

	@Override
	public List<ProductsDto> getAllProducts() {
		List<Products> list = pRepo.findAll();
		List<ProductsDto> li=new ArrayList<>();
		for (Products productDto : list) {
			 ProductsDto convertToDto = ProductsMapper.convertToDto(productDto);
			 li.add(convertToDto);	
		}
		return li;
	}

	@Override
	public ProductsDto getProductById(Integer productId) {
		Optional<Products> byId = pRepo.findById(productId);
		if(byId.isPresent()) {
			Products product = byId.get();
			return ProductsMapper.convertToDto(product);
		}

		return null;
	}

	@Override
	public ProductsDto delProductById(Integer productId) {
		Optional<Products> byId = pRepo.findById(productId);
		if(byId.isPresent()) {
			Products products = byId.get();
			pRepo.deleteById(productId);
			return ProductsMapper.convertToDto(products);
		}
		return null;
	}

	@Override
	public boolean updateStock(Integer productId, Integer quantity) {

		Products product = pRepo.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product not found", "PRODUCT_NOT_FOUND"));
		product.setStock(quantity);
		pRepo.save(product);
		return true;
	}

}
