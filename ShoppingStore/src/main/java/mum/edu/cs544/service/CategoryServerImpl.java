package mum.edu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.model.Category;
import mum.edu.cs544.repository.CategoryRepository;



//import com.finalproject.DAO.CategoryDAO;
//import com.finalproject.model.Category;

//import model.Category;
@Service
public class CategoryServerImpl implements CategoryService {
	
	@Autowired	
	private CategoryRepository categoryDAO;

	@Override
	@Transactional
	public List<Category> getcategorys() {
		
		return  categoryDAO.findAll();
	}

	@Override
	@Transactional
	public void saveCategory(Category category) {
		categoryDAO.save(category);
	}

	@Override
	@Transactional
	public Category getCategory(int categoryId) {
	
		return categoryDAO.findOne(categoryId);
	}

	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		categoryDAO.delete(categoryId);

	}

}
