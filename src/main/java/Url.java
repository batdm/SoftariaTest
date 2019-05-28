import java.util.*;

public class Url {

    private Map<String, String> t_old;//t_old - вчерашнее состояние сайтов
    private Map<String, String> t_new;//t_new - текущее состояние сайтов
    private Set<String> Urls;

    public Url() {
        infestNewTable();
        infestOldTable();
        Urls = new HashSet<>(t_new.keySet());
        Urls.addAll(t_old.keySet());
//        System.out.println("all urls: " + Urls);
    }

    private void infestNewTable() {
        t_new = new HashMap<>();
        t_new.put("s1/1", "p1");    //modified
        t_new.put("s1/2", "p2");
        t_new.put("s2/1", "p1111"); //modified
        t_new.put("s2/3", "p24124");
        t_new.put("s2/4", "p24231");//new
        t_new.put("s3/2", "p33");   //new
        t_new.put("s3/3", "p532");
//        System.out.println("t_new: " + t_new);
    }

    private void infestOldTable() {
        t_old = new HashMap<>();
        t_old.put("s1/1", "p123");
        t_old.put("s1/2", "p2");
        t_old.put("s2/1", "p11");
        t_old.put("s2/2", "p2222"); //lost
        t_old.put("s2/3", "p24124");
        t_old.put("s3/1", "p22");   //lost
        t_old.put("s3/3", "p532");
//        System.out.println("t_old: " + t_old);
    }

    /**
     * @return множество исчезнувших URL
     */
    public Set<String> getLostUrls() {
        Set<String> oldUrls = new HashSet<>(Urls);
        oldUrls.removeAll(t_new.keySet());
        return oldUrls;
    }

    /**
     * @param customerUrl - список url заказчика
     * @return множество исчезнувших URL
     */
    public List<String> getLostUrls(Set<String> customerUrl) {
        return getStrings(customerUrl, t_new);
    }

    /**
     * @return множество новых URL
     */
    public Set<String> getNewUrls() {
        Set<String> newUrls = new HashSet<>(Urls);
        newUrls.removeAll(t_old.keySet());
        return newUrls;
    }

    /**
     * @param customerUrl - список url заказчика
     * @return множество новых URL
     */
    public List<String> getNewUrls(Set<String> customerUrl) {
        return getStrings(customerUrl, t_old);
    }

    /**
     *
     * @param customerUrl - customerUrl - список url заказчика
     * @param t_url - соответствующая таблица, при поиске исчезнувших url - текущая таблица url, при поиске новых url - старая таблица url.
     * @return список необходимых url (исчезнувшие/новые) для конкретного заказчика
     */
    private List<String> getStrings(Set<String> customerUrl, Map<String, String> t_url) {
        List<String> UrlsList = new ArrayList<>();
        Set<String> someUrls = new HashSet<>(Urls);
        someUrls.removeAll(t_url.keySet());
        for (String oe : someUrls) {
            for (String ce : customerUrl) {
                if (oe.contains(ce)) {
                    UrlsList.add(oe);
                }
            }
        }
        return UrlsList;
    }

    /**
     * @return список измененных страниц
     */
    public List<String> getModifiedUrls() {
        Set<String> sameUrls = new HashSet<>(Urls);
        List<String> modifiedUrls = new ArrayList<>();
        sameUrls.removeAll(getNewUrls());
        sameUrls.removeAll(getLostUrls());
        for (String s : sameUrls) {
            if (!t_new.get(s).equals(t_old.get(s))) {
//                System.out.println("изменилась страница с url: " + s);
                modifiedUrls.add(s);
            }
        }
        return modifiedUrls;
    }
    /**
     * @return список измененных страниц
     */
    public List<String> getModifiedUrls(Set<String> customerUrl) {
        List<String> modifiedUrls = getModifiedUrls();
        List<String> modifiedUrlsCustomer = new ArrayList<>();
        for (String oe : modifiedUrls) {
            for (String ce : customerUrl) {
                if (oe.contains(ce)) {
                    modifiedUrlsCustomer.add(oe);
                }
            }
        }
        return modifiedUrlsCustomer;
    }

}
