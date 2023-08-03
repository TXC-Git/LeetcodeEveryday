import java.util.*;

public class Leetcode_128_longestConsecutive {


    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.isEmpty())
            return 0;
        int indexEle = list.get(0) ;
        list.remove(0);
        int tempLength = 1 ;
        int maxLength = 1;
        for(Integer ele : list){
            if(ele==indexEle+1){
                tempLength+=1;
                indexEle=ele;
            }else{
                tempLength=1;
                indexEle=ele;
            }
            maxLength=maxLength>tempLength?maxLength:tempLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int [] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }

}
