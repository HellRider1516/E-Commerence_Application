package in.mahesh.Rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.mahesh.Constants.AppConstants;
import in.mahesh.Dto.ProductsDto;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.ProductsServiceImp;
import in.mahesh.properties.AppProperties;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductsServiceImp service;
	
	@Autowired
	private AppProperties props;
	
	
	@PostMapping("/product")
	public ResponseEntity<ApiResponse<ProductsDto>> addProducts(@RequestBody ProductsDto productsDto ,  @RequestParam("file") MultipartFile file){
		ProductsDto product = service.addProduct(productsDto, file);
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(product != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_Add_SUCC));
			resp.setData(product);
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_Add_ERR));
		}
		
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductsDto>> updateProduct(@RequestBody ProductsDto productsDto , @PathVariable("productId") Integer productId ,@RequestParam("file") MultipartFile file){
		ProductsDto updateProduct = service.updateProduct(productId, productsDto, file);
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(updateProduct != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_UPDATE_SUCC));
			resp.setData(updateProduct);
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_UPDATE_ERR));
		}
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<ApiResponse<ProductsDto>> getAllProducts(){
		List<ProductsDto> allProducts = service.getAllProducts();
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(allProducts != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_RET_SUCC));
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_RET_ERR));
		}
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductsDto>> getProductById(@PathVariable("productId") Integer productId){
		ProductsDto productById = service.getProductById(productId);
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(productById != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_RET_PROID_SUCC));
			resp.setData(productById);
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_RET_PROID_ERR));
		}
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductsDto>> deleteById(@PathVariable("productId") Integer productId){
		ProductsDto delProductById = service.delProductById(productId);
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(delProductById != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_DEL_SUCC));
			resp.setData(delProductById);
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_DEL_ERR));
		}
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.OK);
	}
	
	
	@PatchMapping("/product/{productId}/stock")
	public ResponseEntity<ApiResponse<ProductsDto>> updateStock(@PathVariable("productId") Integer productId , @RequestParam("quantity") Integer quantity){
		boolean updateStock = service.updateStock(productId, quantity);
		ApiResponse<ProductsDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		if(updateStock) {
			resp.setStatusCode(201);
			resp.setMessage(message.get(AppConstants.PRO_STOCK_SUCC));
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get(AppConstants.PRO_STOCK_ERR));
		}
		return new ResponseEntity<ApiResponse<ProductsDto>>(resp, HttpStatus.OK);
	}
	
	


}
