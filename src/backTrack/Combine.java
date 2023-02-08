package backTrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        backtracking(n, k, 1);
        return ans;
    }

    public void backtracking(int n, int k, int start) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtracking(n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
