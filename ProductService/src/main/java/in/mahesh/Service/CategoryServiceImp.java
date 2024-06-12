package in.mahesh.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.mahesh.Dto.CategoryDto;
import in.mahesh.Mapper.CategoryMapper;
import in.mahesh.Repo.CategoryRepo;
import in.mahesh.entity.Category;

@Service
public class CategoryServiceImp implements CategoryService {
	
	private CategoryRepo cRepo;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category c = CategoryMapper.convertToEntity(categoryDto);
		Category savedcategory = cRepo.save(c);
		if(savedcategory.getCategoryId()!=null) {
			return CategoryMapper.convertToDto(savedcategory);
		}
		return null;
	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
		Optional<Category> byId = cRepo.findById(categoryId);
		if(byId.isPresent()) {
			Category category = byId.get();
			 BeanUtils.copyProperties(categoryDto, category);
			 Category productUpadted = cRepo.save(category);
			 return CategoryMapper.convertToDto(productUpadted);
		}
		return null;

	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> list = cRepo.findAll();
		List<CategoryDto> li =new ArrayList<>();
		for (Category categoryDto : list) {
			CategoryDto convertToDto = CategoryMapper.convertToDto(categoryDto);
			li.add(convertToDto);
			
		}
		return li;

	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Optional<Category> byId = cRepo.findById(categoryId);
		if(byId.isPresent()) {
			Category category = byId.get();
			return CategoryMapper.convertToDto(category);
		}
		return null;
	}

	@Override
	public CategoryDto deleteCategoryById(Integer categoryId) {
		Optional<Category> byId = cRepo.findById(categoryId);
		if(byId.isPresent()) {
			cRepo.deleteById(categoryId);
			Category category = byId.get();
			return CategoryMapper.convertToDto(category);
		}
		
		return null;
		
	}
	
	
}
