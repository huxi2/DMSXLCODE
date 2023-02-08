package hashTale;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                ans[0]=map.get(nums[i]);
                ans[1]=i;
                break;
            }else{
                map.put(target - nums[i],i);
            }
        }
        return ans;
    }

    @Test
    public void mytest() {

    }
}
