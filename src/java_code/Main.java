package java_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, String> t_old = new HashMap<>();
        t_old.put("s1/1", "p123");
        t_old.put("s1/2", "p2");
        t_old.put("s2/1", "p11");
        t_old.put("s3/1", "p22"); //lost

        Map<String, String> t_new = new HashMap<>();
        t_new.put("s1/1", "p1");
        t_new.put("s1/2", "p2");
        t_new.put("s2/1", "p1111"); //modified
        t_new.put("s3/2", "p33"); //new

        //ищем исчезнувшие страницы
        //добавляем текущие url-ы в set.
        final Set<String> Urls = new HashSet<>(t_new.keySet());
        //добавляем в тот же set вчерашние url-ы
        Urls.addAll(t_old.keySet());
        System.out.println("all: " + Urls);
        Set<String> newUrls, oldUrls;
//        newUrls = Urls;
//        oldUrls = Urls;
        newUrls = new HashSet<>(Urls);
        oldUrls = new HashSet<>(Urls);

        newUrls.removeAll(t_old.keySet());
        System.out.println("newUrls: " + newUrls);
        //после удаления элементов из newUrls обновляется и Urls! Так не должно быть! Чего я не понимаю???
        //ладно если бы я обновил Urls, тогда обновилась бы и newUrls, но наоборот то как...
        //понял...
        /*было так:
         * newUrls = Urls;
         * oldUrls = Urls;
         * изменил на:
         * newUrls = new HashSet<>(Urls);
         * oldUrls = new HashSet<>(Urls);
         */

        oldUrls.removeAll(t_new.keySet());
        System.out.println("oldUrls: " + oldUrls);

        //осталось найти изменившиеся страницы
        Set<String> sameUrls = new HashSet<>(Urls);
        //из всех url-ов удаляем уникальные, которые есть только в новой или старой таблице
        sameUrls.removeAll(newUrls);
        sameUrls.removeAll(oldUrls);
        System.out.println("sameUrls: " + sameUrls);//получили общие url-ы
        //сраниваем по общему ключу значения из старой и новой таблицы, если не равны, выводим
        for (String s : sameUrls) {
            if (!t_new.get(s).equals(t_old.get(s))) {
                System.out.println("изменилась страница с url: " + s);
            }
        }

    }
}
