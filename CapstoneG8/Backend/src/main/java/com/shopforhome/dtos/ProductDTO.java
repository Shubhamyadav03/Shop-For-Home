package com.shopforhome.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.shopforhome.models.Product;

public class ProductDTO extends Product {
	
	private MultipartFile picture;
	

	public MultipartFile getPic() {
		return picture;
	}


	public void setPic(MultipartFile pic) {
		this.picture = pic;
	}


	public static Product toEntity(ProductDTO dto) {
		Product entity=new Product();
		BeanUtils.copyProperties(dto, entity, "pic");		
		return entity;
	}
}
