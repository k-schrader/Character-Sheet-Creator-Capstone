package org.kalieschrader.CSCPractice2.model;

import java.util.Collection;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class User {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long id;
private String username;
private String userPass;
private String playerName;
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
                name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "role_id", referencedColumnName = "id"))
private Collection<Role> roles;

public User(String username, String userPass, String playerName) {
	super();
	this.username = username;
	this.userPass = userPass;
	this.playerName = playerName;
}
public User() {}
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
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public Collection<Role> getRoles() {
    return roles;
}

public void setRoles(Collection<Role> roles) {
    this.roles = roles;
}
@Override
public int hashCode() {
	return Objects.hash(username, playerName, userPass);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(username, other.username) && Objects.equals(playerName, other.playerName)
			&& Objects.equals(userPass, other.userPass);
}
@Override
public String toString() {
	return "User [username=" + username + ", userPass=" + userPass + ", playerName=" + playerName + "]";
}

}