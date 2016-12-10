package mum.edu.cs544.service;

import java.util.List;

import mum.edu.cs544.model.Product;

public interface ProductService {
	public List<Product> getproducts();
	
	public List<Product> findData(String s);

	public void saveProduct(Product product);

	public Product getProduct(int productId);

	public void deleteProduct(int productId);
}
