package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xxx on 2017-1-20.
 *
 * @author xxx
 */
public class Main2 {
    public static void main(String[] args) {
        List<String> elements = constructList();
        //iterate over a list
        elements.stream().forEach((String e)->System.out.println(e));
        //iterate over a map
        Map<String,String> map = constructMap();
        map.keySet().stream().forEach(k-> System.out.println(k+"-->"+map.get(k)));
    }

    public static void main3(String[] args) {
        //demo the old way to iterator over a list and map.
        List<String> elements = constructList();
        //iterate over a list
        for(String element:elements) {
            System.out.println(element);
        }
        Map<String,String> map = constructMap();
        //iterate over a map
        for(String key:map.keySet()) {
            System.out.println(key+"-->"+map.get(key));
        }
    }

    private static List<String> constructList() {
        return Arrays.asList("s1","s2","s3");
    }

    private static Map<String,String> constructMap() {
        return new HashMap<String,String>() {
            {
                put("k1","v1");
                put("k2","v2");
                put("k3","v3");
            }
        };
    }
}
