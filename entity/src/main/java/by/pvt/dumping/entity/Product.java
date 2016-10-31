package by.pvt.dumping.entity;

public class Product implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    private int id;
    private Category category;
    private User user;
//    private Date date;
    private String name;
    private String description;
    private String mainText;

    public Product() {
        name = "";
        description = "";
        mainText = "";
    }

    public Product(Category category, User user, String name,
                   String description, String mainText) {
        this.category = category;
        this.user = user;
        this.name = name;
        this.description = description;
        this.mainText = mainText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (!description.equals(product.description)) return false;
        return mainText.equals(product.mainText);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + mainText.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainText='" + mainText + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }
}
