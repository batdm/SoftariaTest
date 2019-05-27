package java_code;

import java.util.*;

public class SearchUrl {

    private Map<String, String> t_old;
    private Map<String, String> t_new;
    private Set<String> Urls;

    /**
     * @param t_new - текущее состояние сайтов
     * @param t_old - вчерашнее состояние сайтов
     */
    public SearchUrl(Map<String, String> t_new, Map<String, String> t_old) {
        this.t_new = t_new;
        this.t_old = t_old;
        System.out.println("t_new: " + t_new);
        System.out.println("t_old: " + t_old);
        Urls = new HashSet<>(t_new.keySet());
        Urls.addAll(t_old.keySet());
        System.out.println("all urls: " + Urls);
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
     * @return множество новых URL
     */
    public Set<String> getNewUrls() {
        Set<String> newUrls = new HashSet<>(Urls);
        newUrls.removeAll(t_old.keySet());
        return newUrls;
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

}
