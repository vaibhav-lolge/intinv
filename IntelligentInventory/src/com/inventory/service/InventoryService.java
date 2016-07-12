package com.inventory.service;

import com.inventory.dao.InventoryDAO;
import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;

public class InventoryService implements IInventoryService {
	
	InventoryDAO inventoryDao = new InventoryDAO();

	@Override
	public ReturnMessage saveCategory(Category category) {
		return inventoryDao.saveCategory(category);
	}

}
