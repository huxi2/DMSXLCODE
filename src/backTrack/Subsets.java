package backTrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        backtrack(nums,0);
//        ans.add(new ArrayList<>(temp));
//        for (int i = 1; i <= nums.length; i++) {
//            backtrack(nums, 0, i);
//        }
        return ans;
    }

    public void backtrack(int[] nums, int start, int size) {
        if (temp.size() == size) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, size);
            temp.remove(temp.size() - 1);
        }
    }

    public void backtrack(int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1);
            temp.removeLast();
        }
    }
}
