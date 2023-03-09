package monotonicStack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map映射数字在nums1中的下标
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] ans = new int[nums1.length];

        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                int temp = stack.pop();
                if(map.containsKey(temp)){
                    ans[map.get(temp)] = nums2[i];
                }
            }
            stack.push(nums2[i]);
        }
        return ans;
    }
}
