package backTrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    List<String> ans;
    StringBuffer sb;
    Map<Integer, String> maps;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        sb = new StringBuffer();
        maps = new HashMap<>();
        maps.put(2, "abc");
        maps.put(3, "def");
        maps.put(4, "ghi");
        maps.put(5, "jkl");
        maps.put(6, "mno");
        maps.put(7, "pqrs");
        maps.put(8, "tuv");
        maps.put(9, "wxyz");
        backtrack(0, digits);
        return ans;
    }

    public void backtrack(int start, String digits) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char num = digits.charAt(start);
        String chars = maps.get(num - '0');
        for (char c : chars.toCharArray()) {
            sb.append(c);
            backtrack(start + 1, digits);
            sb.deleteCharAt(start);
        }
    }
}
