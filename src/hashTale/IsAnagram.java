package hashTale;


import org.junit.Test;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (chars[c - 'a'] > 0)
                chars[c - 'a']--;
            else return false;
        }
        return true;
    }
}
