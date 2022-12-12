package codeArrays;

public class RemoveElement {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
