package backTrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans, temp;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int start) {
        if (temp.size() > 4) return;
        if (start == s.length() && temp.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String str : temp) {
                sb.append(str).append('.');
            }
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = start; i < s.length() && Integer.parseInt(s.substring(start, i + 1)) < 256 && i - start < 3; i++) {
            if (i > start && s.charAt(start) == '0') continue;//前导零
            temp.add(s.substring(start, i + 1));
            backtrack(s, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
