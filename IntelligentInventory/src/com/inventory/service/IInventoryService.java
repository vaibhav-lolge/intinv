package com.inventory.service;

import com.inventory.model.Category;
import com.inventory.model.ReturnMessage;

public interface IInventoryService {

	public ReturnMessage saveCategory(Category category);
}
