package com.inventory.service;

import java.util.List;

import com.inventory.dao.InventoryDAO;
import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;

public class InventoryService implements IInventoryService {
	
	InventoryDAO inventoryDao = new InventoryDAO();

	@Override
	public ReturnMessage saveCategory(Category category) {
		return inventoryDao.saveCategory(category);
	}

	@Override
	public List<Category> getCategoryList() {
		return inventoryDao.getCategoryList();
	}

	@Override
	public Category searchCategory(String categoryIdentifier) {
		return inventoryDao.getCategory(categoryIdentifier);
	}

	@Override
	public ReturnMessage updateCategory(Category editedCategory) {
		return inventoryDao.updateCategory(editedCategory);
	}

}
