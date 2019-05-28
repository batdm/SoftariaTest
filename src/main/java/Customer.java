import java.util.Set;

public class Customer {

    private int id;
    private Set<String> urls;
    private String email;
    private String name;

    /**
     *
     * @param urls Set url-ов заказчика
     * @param email почта заказчика
     * @param name ФИО заказчика
     */
    public Customer(Set<String> urls, String email, String name) {
        this.urls = urls;
        this.email = email;
        this.name = name;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
