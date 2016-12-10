package mum.edu.cs544.exception;



public class UserNameNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "there's no user for this User name";
	private String userName;

	public UserNameNotFoundException(String accountNo,String message ) {
		super();
		if (message != null)
			this.message = message;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
}
