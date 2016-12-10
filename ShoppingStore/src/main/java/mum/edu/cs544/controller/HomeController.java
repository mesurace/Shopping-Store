package mum.edu.cs544.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mum.edu.cs544.model.Brand;
import mum.edu.cs544.model.Category;
import mum.edu.cs544.model.Product;
import mum.edu.cs544.service.BrandService;
import mum.edu.cs544.service.CategoryService;
import mum.edu.cs544.service.ProductService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public String siteHome(Model model, HttpServletRequest request) {

		List<Product> listProduct = productService.getproducts();
		model.addAttribute("products", listProduct);
		return "site.homepage";

	}

	@GetMapping("/search")
	public String searchProduct(@ModelAttribute("search") String s, Model model) {
		List<Product> listProduct = productService.findData(s + "%");
		model.addAttribute("products", listProduct);
		return "site.homepage";

	}

	@RequestMapping("/admin")
	public String adminHome(Model model, HttpServletRequest request) {
		List<Product> listProduct = productService.getproducts();
		model.addAttribute("products", listProduct);
		return "site.homepage2";

	}

	@RequestMapping("/categoryList")
	public String getAllCategory(Model model, HttpServletRequest request) {

		List<Category> categoryList = categoryService.getcategorys();

		// add the brand list to the model
		model.addAttribute("categorys", categoryList);

		return "site.category";

	}

	@RequestMapping("/brandList")
	public String getAllBrand(Model model, HttpServletRequest request) {

		List<Brand> brandList = brandService.getbrands();

		// add the brand list to the model
		model.addAttribute("brands", brandList);

		return "site.brand";

	}

}
