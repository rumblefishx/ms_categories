package com.rumblesoftware.cat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumblesoftware.cat.exceptions.CategoryAlreadyExistsException;
import com.rumblesoftware.cat.io.IOConverter;
import com.rumblesoftware.cat.io.input.dto.CategoryInputDTO;
import com.rumblesoftware.cat.io.input.dto.CategoryPatchDTO;
import com.rumblesoftware.cat.io.output.dto.CategoryOutputDTO;
import com.rumblesoftware.cat.model.CategoryEntity;
import com.rumblesoftware.cat.repository.CategoryRepository;
import com.rumblesoftware.cat.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private IOConverter converter;
	
	@Override
	public CategoryOutputDTO addNewCategory(CategoryInputDTO input) {
		CategoryEntity category = null;
		CategoryOutputDTO output = null;
		
		//Category already exists ?
		Optional<CategoryEntity> result = 
				repository.findCategoryByNameAndUser(input.getCustomerId(), input.getCategoryName());
		
		if(result.isPresent()) 
			throw new CategoryAlreadyExistsException();
		
		category = converter.castToEntity(input);
		category = repository.save(category);
		
		output = converter.castToOutput(category);
		
		return output;
	}

	@Override
	public CategoryOutputDTO removeCategory(Long customerId, Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryOutputDTO updateCategory(CategoryPatchDTO patch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryOutputDTO findCategoryById(Long customerId, Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryOutputDTO> getAllCustomerCat(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}