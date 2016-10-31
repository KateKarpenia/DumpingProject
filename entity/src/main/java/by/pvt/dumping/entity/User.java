package by.pvt.dumping.entity;

import java.util.HashSet;
import java.util.Set;

public class User implements AbstractEntity {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int accessLevel;
	private Set<Product> products= new HashSet <Product>();

	public User() {
		firstName = "";
		lastName = "";
		email = "";
		password = "";
	}

	public User(String firstName, String lastName, String email,
				String password, int accessLevel, Set<Product> products) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
		this.products = products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (accessLevel != user.accessLevel) return false;
		if (!firstName.equals(user.firstName)) return false;
		if (!lastName.equals(user.lastName)) return false;
		if (!email.equals(user.email)) return false;
		if (!password.equals(user.password)) return false;
		return products.equals(user.products);

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + accessLevel;
		result = 31 * result + products.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", accessLevel=" + accessLevel +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
