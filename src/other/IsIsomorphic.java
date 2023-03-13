package other;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        //映射  一一对应
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            char v = t.charAt(i);
            if (!map1.containsKey(k) && !map2.containsKey(v)) {
                map1.put(k, v);
                map2.put(v, k);
            } else if (map1.containsKey(k) && map2.containsKey(v)) {
                if (map2.get(v) != k || map1.get(k) != v) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
