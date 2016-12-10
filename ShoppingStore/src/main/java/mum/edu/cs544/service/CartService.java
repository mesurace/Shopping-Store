package mum.edu.cs544.service;

import java.util.List;

import mum.edu.cs544.model.Cart;

public interface CartService {

	public List<Cart> findAll();

	public void saveCart(Cart cart);

	public void deleteCart(int id);
	
	public void deleteAll();
}
