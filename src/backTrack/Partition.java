package backTrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    List<List<String>> ans;
    List<String> temp;

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i));
            } else {
                continue;
            }
            backtrack(s, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
