import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerData {

    private Map<String, Customer> customerMap;

    public CustomerData() {
        Set<String> customer1Url = new HashSet<>();
        customer1Url.add("s1");
        Set<String> customer2Url = new HashSet<>();
        customer2Url.add("s2");
        customer2Url.add("s3");
        Set<String> customer3Url = new HashSet<>();
        customer3Url.add("s3");

        Customer customer1 = new Customer(customer1Url, "customer1@mail.ru", "Михалева Марина Ивановна");
        Customer customer2 = new Customer(customer2Url, "customer2@mail.ru", "Иванов Иван Геннадьевич");
        Customer customer3 = new Customer(customer3Url, "customer3@mail.ru", "Песцова Наталья Васильевна");

        customerMap = new HashMap<>();
        customerMap.put("customer1@mail.ru", customer1);
        customerMap.put("customer2@mail.ru", customer2);
        customerMap.put("customer3@mail.ru", customer3);
    }

    public Customer getCustomer(String email) {
        return customerMap.get(email);
    }
}
