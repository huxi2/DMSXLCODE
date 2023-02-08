package string;

public class RepeatedSubstringPattern {
    //暴力破解
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length() / 2; i++) {
            String sub = s.substring(0, i), temp = s;
            while (temp.startsWith(sub)) {
                temp = temp.substring(sub.length());
            }
            if (temp.length() == 0) return true;
        }
        return false;
    }

    // kmp
    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
        if (len <= 0) return false;
        int[] next = getNext(s);
        return next[len - 1] != -1 && len % (len - next[len - 1] - 1) == 0;
    }

    public int[] getNext(String s) {
        int i = 1, j = -1;
        int[] next = new int[s.length()];
        next[0] = j;
        while (i < s.length()) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1))
                j++;
            next[i++] = j;
        }
        return next;
    }
}
