package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mum.edu.cs544.model.Category;

//import org.springframework.data.repository.CrudRepository;



//import model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	void delete(int categoryId);

	List<Category> findAll();

	Category findOne(int categoryId);

	Category save(Category persisted);

}
