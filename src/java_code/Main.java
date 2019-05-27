package java_code;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> t_old = new HashMap<>();
        t_old.put("s1/1", "p123");
        t_old.put("s1/2", "p2");
        t_old.put("s2/1", "p11");
        t_old.put("s2/2", "p2222"); //lost
        t_old.put("s2/3", "p24124");
        t_old.put("s3/1", "p22");   //lost
        t_old.put("s3/3", "p532");

        Map<String, String> t_new = new HashMap<>();
        t_new.put("s1/1", "p1");    //modified
        t_new.put("s1/2", "p2");
        t_new.put("s2/1", "p1111"); //modified
        t_new.put("s2/3", "p24124");
        t_new.put("s2/4", "p24231");//new
        t_new.put("s3/2", "p33");   //new
        t_new.put("s3/3", "p532");


        SearchUrl searchUrl = new SearchUrl(t_new, t_old);
        System.out.println("getLostUrls: " + searchUrl.getLostUrls());
        System.out.println("getNewUrls: " + searchUrl.getNewUrls());
        System.out.println("getModifiedUrls: " + searchUrl.getModifiedUrls());

    }
}
