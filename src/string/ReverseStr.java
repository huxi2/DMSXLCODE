package string;

import org.junit.Test;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(i + k, s.length()) - 1;
            while (start < end) {
                char c = str[start];
                str[start] = str[end];
                str[end] = c;
                start++;
                end--;
            }
        }
        return new String(str);
    }
}
