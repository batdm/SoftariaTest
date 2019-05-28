import java.util.Set;

public class Letter {

    public String getText(String email) {
        CustomerData customerData = new CustomerData();
        //список url-ов заказчика
        Set<String> customerUrls = customerData.getCustomer(email).getUrls();
        //ФИО заказчика
        String name = customerData.getCustomer(email).getName();
//        System.out.println("customerUrls: " + customerUrls + ", name: " + name);
        Url url = new Url();
//        System.out.println("LostUrls for email '" + email + "': " + url.getLostUrls(customerUrls));
//        System.out.println("NewUrls for email '" + email + "': " + url.getNewUrls(customerUrls));
//        System.out.println("ModifiedUrls for email '" + email + "': " + url.getModifiedUrls(customerUrls));

        String text = "Здравствуйте, дорогой(ая) " + name + "\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n" +
                "1) Исчезли следующие страницы:\n" +
                url.getLostUrls(customerUrls) + "\n" +
                "2) Появились следующие новые страницы:\n" +
                url.getNewUrls(customerUrls) + "\n" +
                "3) Изменились следующие страницы:\n" +
                url.getModifiedUrls(customerUrls) + "\n" +
                "\n" +
                "С уважением,\n" +
                "автоматизированная система мониторинга.";
        return text;
    }
}
