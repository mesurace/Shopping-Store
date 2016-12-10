package mum.edu.cs544.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mum.edu.cs544.model.Category;
import mum.edu.cs544.service.CategoryService;

//import model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(BrandController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/list")
	public String getList(Model model) {

		// get the category list from dao
		List<Category> categoryList = categoryService.getcategorys();

		// add the category list to the model
		model.addAttribute("categorys", categoryList);

		return "list-categorys";
	}

	@GetMapping("showFormForAdd")
	public String showFormAdd(Model model) {

		// create model attribute to bind form data
		Category categoryObj = new Category();
		model.addAttribute("category", categoryObj);

		return "category-form";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@Valid @ModelAttribute("category") Category categoryObj, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// logger.info("Logger Name" + logger.getName());
			// logger.error("Category Form Invalid");

			return "category-form";
		} else {
			// save the category using our service

			categoryService.saveCategory(categoryObj);
			return "redirect:/category/list";
		}
	}

	@GetMapping("showFormForUpdate")
	public String showFormUpdate(@RequestParam("categoryId") int idobj, Model model) {

		// get category from service
		Category categoryObj = categoryService.getCategory(idobj);// getCustomer(idobj);

		// set category as model attribute to pre-populate the form
		model.addAttribute("category", categoryObj);

		// send over our form
		return "category-form";
	}

	@GetMapping("/delete")
	public String showdelete(@RequestParam("categoryId") int idobj) {

		// delete the category
		categoryService.deleteCategory(idobj);// (idobj);

		return "redirect:/category/list";
	}

}
