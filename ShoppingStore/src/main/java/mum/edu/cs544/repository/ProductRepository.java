package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mum.edu.cs544.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	void delete(int productId);

	List<Product> findAll();

	Product findOne(int productId);

	Product save(Product persisted);
	
	@Query("select p from Product p where p.name like :s")
	List<Product> findData(@Param("s") String s);

}
