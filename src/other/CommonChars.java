package other;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CommonChars {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < words.length; i++) {
            int temp[] = new int[26];
            for (char c : words[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    count[j] = temp[j];
                } else {
                    count[j] = Math.min(count[j], temp[j]);
                }
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                char c = (char) ('a' + i);
                ans.add(String.valueOf(c));
                count[i]--;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String[] words = {"cool", "lock", "cook"};
        commonChars(words);
    }
}
