package backTrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        backtrack(k, n, 1, 0);
        return ans;
    }

    public void backtrack(int k, int n, int start, int sum) {
        if (sum > n || temp.size() > k) return;
        if (temp.size() == k && sum == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < 10; i++) {
            temp.add(i);
            backtrack(k, n, i + 1, sum + i);
            temp.remove(temp.size() - 1);
        }
    }
}
