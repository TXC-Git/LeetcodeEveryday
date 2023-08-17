package NormalArray;

public class Leetcode_238_productExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] ans = new int[len];
        int [] preProduct = new int[len];
        int [] postProduct = new int[len];
        preProduct[0]=1;
        for(int i = 1 ; i < len ; i++){
            preProduct[i]=preProduct[i-1]*nums[i-1];
        }
        postProduct[len-1]=1;
        for(int i = len-2 ; i >=0 ; i--){
            postProduct[i]=postProduct[i+1]*nums[i+1];
        }

        for(int i = 0 ; i < len ; i++){
            ans[i]=preProduct[i]*postProduct[i];
        }
        return ans;
    }

    public static void main(String[] args) {
       int [] nums = {-1,1,0,-3,3};
       int [] ans = productExceptSelf(nums);
       for(int ele : ans){
           System.out.print(ele + " , ");
       }
    }
}
