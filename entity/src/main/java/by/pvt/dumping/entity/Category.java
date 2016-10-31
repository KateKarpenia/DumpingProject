package by.pvt.dumping.entity;

//public enum Category {
//	ALL, SOUVENIRS, CALENDARS, PRINTING, PROMOSTANDS, EVENT, OTHER;
//}

import java.util.HashSet;
import java.util.Set;

public class Category implements AbstractEntity {

	private static final long serialVersionUID = 1L;
	private int id;
	private String category;
	private Set<Product> products = new HashSet<>();

	public Category() {
		category = "";
	}

	public Category(String category, Set<Product> products) {
		this.category = category;
		this.products = products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category category = (Category) o;

		return category.equals(category.category);

	}

	@Override
	public int hashCode() {
		return category.hashCode();
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", category='" + category + '\'' +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
