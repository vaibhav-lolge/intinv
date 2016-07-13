package com.inventory.service;

import java.util.List;

import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;

public interface IInventoryService {

	public ReturnMessage saveCategory(Category category);
	
	public List<Category> getCategoryList();

	public Category searchCategory(String categoryIdentifier);

	public ReturnMessage updateCategory(Category editedCategory);
}
