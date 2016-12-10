package mum.edu.cs544.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Card {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Please enter the card number")
	private String number;


	@Enumerated(EnumType.STRING)
	private CardType type;
	
	@NotNull(message="Please enter the year")
	private int year;
	
	@NotNull(message="Please enter the month")
	private int month;
	
	@NotNull(message="Please enter the code")
	private int code;
	
	/*@OneToOne
	@JoinColumn(name = "userId")
	private User user;*/

}
