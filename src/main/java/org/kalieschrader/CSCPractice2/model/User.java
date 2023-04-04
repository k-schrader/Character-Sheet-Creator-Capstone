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
private String userEmail;
private String userPass;
private String userName;
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
                name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "role_id", referencedColumnName = "id"))
private Collection<Role> roles;

public User(String userEmail, String userPass, String userName) {
	super();
	this.userEmail = userEmail;
	this.userPass = userPass;
	this.userName = userName;
}
public User() {}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Collection<Role> getRoles() {
    return roles;
}

public void setRoles(Collection<Role> roles) {
    this.roles = roles;
}
@Override
public int hashCode() {
	return Objects.hash(userEmail, userName, userPass);
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
	return Objects.equals(userEmail, other.userEmail) && Objects.equals(userName, other.userName)
			&& Objects.equals(userPass, other.userPass);
}
@Override
public String toString() {
	return "User [userEmail=" + userEmail + ", userPass=" + userPass + ", userName=" + userName + "]";
}

}