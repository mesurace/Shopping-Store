package mum.edu.cs544.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.cs544.exception.UserNameNotFoundException;
import mum.edu.cs544.service.UserService;
import mum.edu.cs544.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userform")
	public String showUserForm(@ModelAttribute("user") User user,Model model){
		/*List<User> listUser=userservice.getAll()*/
		//User user = new User();
		model.addAttribute("user",user);
		return "userform";
	}
	
	@RequestMapping(value = { "/userform" }, method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user,BindingResult result,  RedirectAttributes rAttributes) {
		
		
	if (result.hasErrors()) {
		//BindingResult result,
			return "userform";
	}
	
	List<User> users=userService.getAll();
	
	for(User u:users){
		if(user.getUserCredential().getUserName().equals(u.getUserCredential().getUserName())){
			user.getUserCredential().setUserName(u.getUserCredential().getUserName());
			userService.deleteUser(u.getId());
		}
	}
		
		userService.addUser(user);
		
		rAttributes.addFlashAttribute("user", user);
		return "redirect:success";
	}
	
	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public String showSecondForm(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users",users);
		return "success";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormUpdate(@RequestParam("userName") String userName, Model model) {
		System.out.println(userName+"#############################################");
		// get user from service
		User userobj = userService.getUser(userName);
		
		
		
		System.out.println(userobj == null);
		
		// set user as model attribute to pre-populate the form
		model.addAttribute("user", userobj);
		// send over our form
		return "userUpdate";
	}
	
	
	@GetMapping("/delete")
	public String showdelete(@RequestParam("id") int id) {
		// delete the brand
		System.out.println(id);
		userService.deleteUser(id);
		return "redirect:success";
		
	}
	
	
	
	@RequestMapping(value="/getUser/{userName}", method = RequestMethod.GET)	
	public @ResponseBody User getUserFromDatabase(@RequestParam("userName") String userName, User user) throws UserNameNotFoundException{
		System.out.println(userName+"Test");
		user=userService.getUser(userName);
		System.out.println(user+"test");
		return user;
	}
	
	/*@RequestMapping(value="/searchform", method=RequestMethod.GET)
	public String userSearchForm()
	{
		return "userSearch";
	}*/
	
	@RequestMapping(value="/searchform", method=RequestMethod.GET)
	public String userSearch()
	{
		return "userDetails";
	}
	
	@RequestMapping(value="/userDetails", method=RequestMethod.GET)
	public String showUserDetails()
	{
		return "userDetails";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason="Illegal request, please verify your dataInput")
	public void handleClientErrors(Exception ex) { }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="There's an Internal server error ")
	public void handleServerErrors(Exception ex) {	}
	
	@RequestMapping(value="/search_user/{userName}",method=RequestMethod.GET)
	public @ResponseBody User restDisplayUser(@PathVariable("userName") String userName){
		return userService.getUser(userName);
	}
	
	
//	@RequestMapping(value="/useredit")
//	public String editUserInfo(@ModelAttribute("user") User user,Model model)
//	{
//		
//		return "userform";
//	}
//	
	
	/*@RequestMapping(value="/useredit")
	public String showFormUpdate(@RequestParam("user") String userName, Model model) {
		// get brand from service
		User userObj = userService.getUser(userName);
		// set brand as model attribute to pre-populate the form
		model.addAttribute("user", userObj);
		// send over our form
		return "Redirect:/useredit?user"+userName;
	}*/
	/*@RequestMapping(value="/useredit")
	public String userEdit(@ModelAttribute("user") User user,Model model){
		List<User> listUser=userservice.getAll()
		//User user = new User();
		model.addAttribute("user",user);
		return "userform";
	}*/
	
	

}
