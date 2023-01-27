package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            if(i>start && candidates[i]==candidates[i-1])continue;
            temp.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
