package mum.edu.cs544.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.cs544.model.Category;
import mum.edu.cs544.model.Product;
import mum.edu.cs544.service.BrandService;
import mum.edu.cs544.service.CategoryService;
import mum.edu.cs544.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService catetoryService;

	@Autowired
	private BrandService brandService;

	@RequestMapping("list")
	public String getList(Model model) {
		// get the list from repository
		List<Product> listProduct = productService.getproducts();

		// add the product list to the model
		model.addAttribute("products", listProduct);
		return "list-products";
	}

	// for pop up form for add
	@GetMapping("showFormForAdd")
	public String getaddForm(Model model) {
		// create attribute to bind from data
		Product productObj = new Product();
		model.addAttribute("product", productObj);

		model.addAttribute("categories", catetoryService.getcategorys());

		model.addAttribute("brands", brandService.getbrands());

		return "product-form";

	}

	/*
	 * // for saving
	 * 
	 * @PostMapping("saveProduct") public String
	 * getSaveProduct(@ModelAttribute("product") Product productObj) { // saving
	 * using service productService.saveProduct(productObj); return
	 * "redirect:/product/list"; }
	 */

	// for saving
	@PostMapping("saveProduct")
	public String getSaveProduct(@Valid @ModelAttribute("product") Product productObj, BindingResult result) {

		if (result.hasErrors()) {

			return "product-form";
		}

		else {

			MultipartFile userImage = productObj.getImage();
			String rootDirectory = servletContext.getRealPath("/");

			// isEmpty means file exists BUT NO Content
			if (userImage != null && !userImage.isEmpty()) {
				try {
					
  				userImage.transferTo(new File(rootDirectory + "/resources/images/" + productObj.getName() + ".jpg"));
				} catch (Exception e) {
					System.out.println(e);
					throw new RuntimeException(" Image saving failed", e);
				}
			}

			// saving using service
			productService.saveProduct(productObj);
			return "redirect:/product/list";
		}
	}

	

	// for updating
	@GetMapping("showFormForUpdate")
	public String getUpdateForm(@RequestParam("productId") int idObj, Model model) {

		// get product from service
		Product product = productService.getProduct(idObj);

		model.addAttribute("product", product);
		model.addAttribute("categories", catetoryService.getcategorys());

		model.addAttribute("brands", brandService.getbrands());

		// send over form

		return "product-form";
	}

	// for delete
	@GetMapping("/delete")
	public String getDelete(@RequestParam("productId") int idObj) {
		// delete the data
		productService.deleteProduct(idObj);
		return "redirect:/product/list";
	}
}
