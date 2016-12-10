package mum.edu.cs544.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

//import com.journaldev.spring.HomeController;

import mum.edu.cs544.model.Brand;
import mum.edu.cs544.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	// private static final Logger logger =
	// LoggerFactory.getLogger(BrandController.class);

	@Autowired
	private BrandService brandService;

	@RequestMapping("/list")
	public String getList(Model model) {

		// get the brand list from dao
		List<Brand> brandList = brandService.getbrands();

		// add the brand list to the model
		model.addAttribute("brands", brandList);

		return "list-brands";
	}

	@GetMapping("showFormForAdd")
	public String showFormAdd(Model model) {

		// create model attribute to bind form data
		Brand brandObj = new Brand();
		model.addAttribute("brand", brandObj);

		return "brand-form";
	}

	@PostMapping("/saveBrand")
	public String saveBrand(@Valid @ModelAttribute("brand") Brand brandObj, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			// logger.info("Logger Name"+logger.getName());
			// logger.error("Brand Form Invalid");

			return "brand-form";
		} else {

			// save the brand using our service

			brandService.saveBrand(brandObj);
			return "redirect:/brand/list";
		}
	}

	@GetMapping("/checkout")
	public String checkOut(){//@ModelAttribute("brand") Brand brand, BindingResult br) {

		Brand brand2 = new Brand();
		brand2.setId(1);
		brand2.setBrandName("New Rest Brand");

	//	if (!br.hasErrors()) {
			final String uri = "http://localhost:8090/person/list";
			RestTemplate restTemplate = new RestTemplate();

			Brand result = restTemplate.postForObject(uri, brand2, Brand.class);
			// System.out.println(result() + "\n" + result.getType());
			System.out.println("========= ====================================" + "\n" + result.getId() + "\n"
					+ result.getBrandName());
		//}
		return "redirect:/brand/list";
	}

	@GetMapping("showFormForUpdate")
	public String showFormUpdate(@RequestParam("brandId") int idobj, Model model) {

		// get brand from service
		Brand brandObj = brandService.getBrand(idobj);// getCustomer(idobj);

		// set brand as model attribute to pre-populate the form
		model.addAttribute("brand", brandObj);

		// send over our form
		return "brand-form";
	}

	@GetMapping("/delete")
	public String showdelete(@RequestParam("brandId") int idobj) {

		// delete the brand
		brandService.deleteBrand(idobj);// (idobj);

		return "redirect:/brand/list";
	}

}
