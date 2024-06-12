package in.mahesh.Rest;

import java.util.List;
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

import in.mahesh.Dto.CategoryDto;
import in.mahesh.Response.ApiResponse;
import in.mahesh.Service.CategoryServiceImp;
import in.mahesh.properties.AppProperties;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CategoryRestController {
	
	@Autowired
	private CategoryServiceImp service;
	
	@Autowired
	private AppProperties props;
	
	
	

	@PostMapping("/Category")
	public ResponseEntity<ApiResponse<CategoryDto>> addCategory(@RequestBody CategoryDto categoryDto){
		Map<String, String> message = props.getMessage();
		
		CategoryDto category = service.addCategory(categoryDto);
		
		ApiResponse<CategoryDto> resp = new ApiResponse<>();
		
		if(category != null) {
			resp.setStatusCode(201);
			resp.setMessage(message.get("categoryAdded"));
			resp.setData(category);
		}else{
			resp.setStatusCode(500);
			resp.setMessage(message.get("categoryAddErr"));
		}
		return new ResponseEntity<ApiResponse<CategoryDto>>(resp, HttpStatus.CREATED);

		
	}
	
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse<CategoryDto>> upateCategory(@RequestBody CategoryDto categoryDto ,@PathVariable("categoryId") Integer categoryId){
		CategoryDto updateCategory = service.updateCategory(categoryId, categoryDto);
		Map<String, String> message = props.getMessage();
		
		ApiResponse<CategoryDto> resp = new ApiResponse<>();
		
		if(updateCategory != null) {
			resp.setData(updateCategory);
			resp.setMessage(message.get("categoryUpdate"));
			resp.setStatusCode(201);
		}else {
			resp.setMessage(message.get("categoryUpdateErr"));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CategoryDto>>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/categories")
	public ResponseEntity<ApiResponse<List<CategoryDto>>> getAllCategories(){
		Map<String, String> message = props.getMessage();
		List<CategoryDto> allCategories = service.getAllCategories();
		ApiResponse<List<CategoryDto>> resp = new ApiResponse<>();
		
		if(allCategories != null) {
			resp.setData(allCategories);
			resp.setMessage(message.get("categoryFetch"));
			resp.setStatusCode(201);
		}else {
			resp.setMessage(message.get("categoryFetchErr"));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<List<CategoryDto>>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse<CategoryDto>> getCategoryById(@PathVariable("categoryId") Integer categoryId){
		CategoryDto categoryById = service.getCategoryById(categoryId);
		ApiResponse<CategoryDto> resp = new ApiResponse<>();
		Map<String, String> message = props.getMessage();
		
		if(categoryById != null) {
			resp.setData(categoryById);
			resp.setMessage(message.get("categorySelect"));
			resp.setStatusCode(201);
		}else {
			resp.setMessage(message.get("categorySelectErr"));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CategoryDto>>(resp, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse<CategoryDto>> deleteCategoryById(@PathVariable("categoryId") Integer categoryId){
		CategoryDto deleteCategoryById = service.deleteCategoryById(categoryId);
		Map<String, String> message = props.getMessage();
		
		ApiResponse<CategoryDto> resp = new ApiResponse<>();
		
		if(deleteCategoryById != null) {
			resp.setData(deleteCategoryById);
			resp.setMessage(message.get("categoryDelete"));
			resp.setStatusCode(201);
		}else {
			resp.setMessage(message.get("categoryDeleteErr"));
			resp.setStatusCode(500);
		}
		return new ResponseEntity<ApiResponse<CategoryDto>>(resp, HttpStatus.OK);
	}
	
	
	
	
}
