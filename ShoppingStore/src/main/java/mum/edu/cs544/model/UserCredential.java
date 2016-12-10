package mum.edu.cs544.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

public class UserCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ucrdId;
	@NotEmpty
	@Size(min = 2, max = 30)
	private String userName;
	private String password;
	String authority = "ROLE_USER";
	@Transient
	private String rePassword;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getUcrdId() {
		return ucrdId;
	}

	public void setUcrdId(int ucrdId) {
		this.ucrdId = ucrdId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	@Override
	public String toString() {
		return "UserCredential [ucrdId=" + ucrdId + ", userName=" + userName + ", authority=" + authority + "]";
	}

}
