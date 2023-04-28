package org.kalieschrader.CSCPractice2.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public class UserData implements Serializable {

    public UserData(@NotEmpty(message = "First name can not be empty") String playerName,
			@NotEmpty(message = "Email can not be empty") @Email(message = "Please provide a valid email id") String username,
			@NotEmpty(message = "Password can not be empty") String userPass) {
		super();
		this.playerName = playerName;
		this.username = username;
		this.userPass = userPass;
	}
    public UserData() {}

	@NotEmpty(message = "First name can not be empty")
    private String playerName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String username;

    @NotEmpty(message = "Password can not be empty")
    private String userPass;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


}