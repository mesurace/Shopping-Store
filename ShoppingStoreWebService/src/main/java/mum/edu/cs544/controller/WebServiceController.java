package mum.edu.cs544.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.cs544.model.CardModel;

@Controller
public class WebServiceController {


	@ResponseBody
	@PostMapping("/cardservice")
	public CardModel getValidCard(@Valid @RequestBody CardModel card, BindingResult bindingResult) throws MyException {
		if (bindingResult.hasErrors()) {
		          throw new MyException("Credit Card is not Valid");
		    
		} else {
			return card;
		}
		
	}
	


}
