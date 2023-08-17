package NormalArray;

public class Leetcode_53_maxSubArray {


    //给你一个整数数组 nums ，请你找出一个具有最大和的
    // 连续子数组（子数组最少包含一个元素），返回其最大和。
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = 0;
        for(int ele : nums){
           max = Math.max(max+ele,ele);
           ans = Math.max(ans,max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }



}
