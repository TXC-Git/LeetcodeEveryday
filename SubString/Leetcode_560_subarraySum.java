package SubString;

public class Leetcode_560_subarraySum {
    /**
     * 一、暴力法：丑陋，真tm的丑陋，时间复杂度O(n2)，空间复杂度O(1)
     */
//    public static int subarraySum(int[] nums, int k) {
//        int count=0;
//        for(int i = 0 ; i < nums.length ; i++){
//            int j = i;
//            int sum = 0;
//            while(j<nums.length){
//                sum+=nums[j];
//                if(sum==k){
//                    count++;
//                }
//                j++;
//            }
//        }
//        return count;
//    }

    public static int subarraySum(int[] nums, int k){

        return 0;
    }
    public static void main(String[] args) {
        int [] nums = new int [] {1, -1, 0};
        int k = 0;
        int result = subarraySum(nums,k);
        System.out.println(result);
    }

}
