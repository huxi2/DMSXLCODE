package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans;
    List<Integer> temp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum >= target) {
            if (sum == target) ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    //优化
    public void backtrack2(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //在for循环中处理剪枝 要比 if 中处理要 更优
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            temp.add(candidates[i]);
            backtrack2(candidates, target, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
