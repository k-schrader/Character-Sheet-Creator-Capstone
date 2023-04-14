package org.kalieschrader.CSCPractice2.DTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})

public class UserDto {

 
	private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should be empty")
    private String password;
    @NotEmpty
    private String confirmPassword;
    @Email
    @NotEmpty
    private String confirmEmail;
    public UserDto(Long id, @NotEmpty String firstName,
 			@NotEmpty(message = "Email should not be empty") @Email String email,
 			@NotEmpty(message = "Password should be empty") String password) {
 		super();
 		this.id = id;
 		this.firstName = firstName;
 		this.email = email;
 		this.password = password;
 	}
    public UserDto() {}


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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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


