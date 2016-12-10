package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mum.edu.cs544.model.Cart;
import mum.edu.cs544.model.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	void delete(int id);
	
	void deleteAll();

	List<Cart> findAll();

	Cart save(Cart cart);

//	@Query("select c.products from Cart c")
//	List<Product> find();

}