package mum.edu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.model.Cart;
import mum.edu.cs544.repository.CartRepository;


@Service
public class CartServiceImp implements CartService{

	
	
	@Autowired
	private CartRepository cartRepo;
	
	@Transactional
	@Override
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}

	@Transactional
	@Override
	public void saveCart(Cart cart) {
		cartRepo.save(cart);
		
	}

	@Transactional
	@Override
	public void deleteCart(int id) {
		cartRepo.delete(id);
		
	}
	
	@Transactional
	@Override
	public void deleteAll() {
		cartRepo.deleteAll();
		
	}

	

}
