package string;

public class StrStr {

    // 暴力破解
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int i = 0, j = -1;
        while (i < haystack.length() && j + 1 < needle.length()) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            i++;
        }
        return j + 1 == needle.length() ? i - j - 1 : -1;
    }

    //i表示后缀的末尾  j表示前缀的末尾
    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }

            if (needle.charAt(i) == needle.charAt(j + 1)) j++;
            next[i] = j;
        }
        return next;
    }
}
