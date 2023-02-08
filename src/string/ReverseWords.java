package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) sb.append(" ");
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }


    //双指针  从后往前遍历
    public String reverseWords2(String s) {
        int index = s.length() - 1;  //从后往前遍历
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            //去掉空格
            while (index >= 0 && s.charAt(index) == ' ') index--;
            //统计单词
            while (index >= 0 && s.charAt(index) != ' ') index--;

            //从前往后
            int temp = index + 1;
            while (temp < s.length() && s.charAt(temp) != ' ') sb.append(s.charAt(temp++));
            if (temp != index + 1) sb.append(' ');//真正有单词
        }
        return sb.substring(0, sb.length() - 1);
    }

}
