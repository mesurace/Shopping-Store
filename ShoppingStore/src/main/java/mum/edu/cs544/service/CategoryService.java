package mum.edu.cs544.service;

import java.util.List;

import mum.edu.cs544.model.Category;

//import com.finalproject.model.Category;

//import model.Category;

public interface CategoryService {
	public List<Category> getcategorys();

	public void saveCategory(Category category);

	public Category getCategory(int categoryId);

	public void deleteCategory(int categoryId);

}
