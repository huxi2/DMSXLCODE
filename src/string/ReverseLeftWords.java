package string;

public class ReverseLeftWords {

    public void reverse(int start, int end, char[] s) {
        while (start < end) {
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }

    public String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        reverse(0, s.length() - 1, str);
        reverse(0, s.length() - n - 1, str);
        reverse(s.length() - n, s.length() - 1, str);
        return new String(str);
    }
}
