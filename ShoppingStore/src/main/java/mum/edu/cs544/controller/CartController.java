package mum.edu.cs544.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.edu.cs544.model.Cart;
import mum.edu.cs544.model.Product;
import mum.edu.cs544.service.CartService;
import mum.edu.cs544.service.ProductService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String loadCart(Model model) {
		double sum=0;
		for(Cart c: cartService.findAll() ){
			sum=sum+c.getTotalCost();
		}
		model.addAttribute("carts", cartService.findAll());
		model.addAttribute("totalPrice",sum);
		return "site.cart";
	}

	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("productId") int idObj, Model model) {

		Product product = productService.getProduct(idObj);
		List<Cart> carts = cartService.findAll();
		boolean itemCheckFlag = true;

		for (Cart c : carts) {
			if (c.getProduct().getId() == idObj) {
				System.out.println("-----============-------------------------------=========");
				Cart cart = new Cart();
				cart.setProduct(product);
				cart.setQuantity(c.getQuantity() + 1);
				//cart.setCartId(c.getCartId());
				cartService.deleteCart(c.getCartId());
				cartService.saveCart(cart);
				itemCheckFlag = false;
				break;
			}
		}
		if (itemCheckFlag) {
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(1);
			cartService.saveCart(cart);
		}

		return "redirect:/cart";
	}

	/*
	 * @PostMapping("/addCart") public String
	 * saveBrand(@ModelAttribute("person") Product product) {
	 * cartService.saveCard(cart); return "redirect:/cart"; }
	 */

	@GetMapping("/deleteCart")
	public String showdelete() {
		cartService.deleteAll();
		return "/cart";
	}
	

}
