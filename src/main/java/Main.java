public class Main {

    public static void main(String[] args) {
        Letter letter = new Letter();
        System.out.println(letter.getText("customer2@mail.ru"));

        //не настроена отправка письма по заданному email адресу
//        SendEmailSSL sendEmailSSL = new SendEmailSSL();
//        sendEmailSSL.send();

    }
}
