package in.mahesh.Mapper;

import org.modelmapper.ModelMapper;

import in.mahesh.Dto.ProductsDto;
import in.mahesh.entity.Products;

public class ProductsMapper {
	
	private static final ModelMapper mapper = new ModelMapper();
	
	public static ProductsDto convertToDto(Products products) {
		return mapper.map(products, ProductsDto.class);
	}
	
	
	
	public static Products convertToEntity(ProductsDto productsDto) {
		return mapper.map(productsDto, Products.class);
	}

}
