package mum.edu.cs544.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import mum.edu.cs544.model.Card;
import mum.edu.cs544.model.CardType;

@Controller
@RequestMapping("/card")
public class CardController {

	@GetMapping("/form")
	public String cardAddForm(Model model) {

		List<CardType> cardType = Arrays.asList(CardType.values());

		Card card1 = new Card();
		model.addAttribute("card", card1);
		model.addAttribute("cards", CardType.values());
		return "site.cardForm";

	}

	@PostMapping("checkout")
	public String checkOut(@Valid @ModelAttribute("card") Card card, BindingResult bindingResults, Model model) {
		if (bindingResults.hasErrors()) {

			return "site.cardForm";
		} else {

			final String uri = "http://localhost:8085/cardservice"; // service must be running in 8085 port 
			RestTemplate restTemplate = new RestTemplate();
			String message = "";

			try {
				Card result = restTemplate.postForObject(uri, card, Card.class);

				System.out.println(result.getNumber() + "\n" + result.getType());

				message = result.getId() + "\n" + result.getCode() + "\n" + result.getMonth() + "\n"
						+ result.getNumber() + "\n" + result.getYear() + "\n" + result.getType();

			} catch (Exception e) {
				System.out.println(e.getMessage());
				message = "Credit card is not valid";
			}

			List<CardType> cardType = Arrays.asList(CardType.values());

			Card card1 = new Card();
			model.addAttribute("card", card1);
			model.addAttribute("cards", CardType.values());
			model.addAttribute("responsemsg", message);
			return "site.cardForm";

		}
	}

}
