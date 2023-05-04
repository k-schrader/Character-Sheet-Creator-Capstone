
package org.kalieschrader.CSC.model;

import java.util.Collection;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

//Model class for User
//It is mapped to the table with annotations and contains all the column values, constructors, and getters/setters
//It has the overridden Hashcode, Equals, and toString methods for testing 
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Users can have multiple roles, and roles can be
																	// associated with multiple users - EAGER loads Role
																	// immediately when User is loaded
	@JoinTable(name = "users_roles", // Creates a joined table named "users_roles"
			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, // Column in the join table
			inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") } // Column in the join
																								// table
	)
	private Collection<Role> roles;

	public User(String firstName, String email, String password) {
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String email, String password, Collection<Role> roles) {
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> role) {
		this.roles = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, password);
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
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [username=" + email + ", userPass=" + password + ", playerName=" + firstName + "]";
	}

	public boolean isEnabled() {
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}