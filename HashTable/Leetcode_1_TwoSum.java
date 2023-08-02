import java.util.HashMap;
import java.util.Map;

public class Leetcode_1_TwoSum {

    //一、暴力解法

    // public int[] twoSum(int[] nums, int target) {
    //     int [] result = {-1,-1};
    //     for(int i = 0 ; i < nums.length - 1 ;i++){
    //         for(int j = i + 1 ; j < nums.length ; j++){
    //             if(nums[i]+nums[j]==target){
    //                 result[0]=i;
    //                 result[1]=j;
    //                 return result;
    //             }
    //         }
    //     }
    //     return result;
    // }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(target-nums[i])){
                return new int []{i , map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("找不到符合的两个数");
    }

}
