package mum.edu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.model.Product;
import mum.edu.cs544.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional
	public List<Product> getproducts() {

		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	@Transactional
	public Product getProduct(int productId) {

		return productRepository.findOne(productId);
	}

	@Override
	@Transactional
	public void deleteProduct(int productId) {
		productRepository.delete(productId);

	}

	@Override
	public List<Product> findData(String s) {
		return productRepository.findData(s);
	}

//	@Override
//	@Transactional
//	public List<Product> findData() {
//		// TODO Auto-generated method stub
//		return productRepository.findData();
//	}

}
