package org.kalieschrader.CSC.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

//Here we finally use our FieldMatch annotation to make sure the fields "first" and "second" match
//If not, the message is displayed 
@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
		@FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match") })

//UserDto is a data transfer object that transfers our data between the frontend and the backend 
public class UserDto {

	@NotEmpty
	private String firstName;
	@NotEmpty(message = "Email should not be empty") // Error message for empty email
	@Email
	private String email;
	@NotEmpty(message = "Password should not be empty") // Error message for empty password
	private String password;
	@NotEmpty
	private String confirmPassword;
	@Email
	@NotEmpty
	private String confirmEmail;

	// Constructor with all arguments
	public UserDto(@NotEmpty String firstName, @NotEmpty(message = "Email should not be empty") @Email String email,
			@NotEmpty(message = "Password should not be empty") String password) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	// Default constructor
	public UserDto() {
	}

	// Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

}
