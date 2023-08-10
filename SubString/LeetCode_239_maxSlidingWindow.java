package SubString;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_239_maxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int [] ans = new int[len-k+1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });

        for(int i = 0 ; i < k ; i++){
            priorityQueue.offer(new int[]{nums[i],i});
        }

        ans[0]=priorityQueue.peek()[0];

        for(int i = k ; i < len ; i++){
            priorityQueue.offer(new int[]{nums[i],i});
            while(priorityQueue.peek()[1]<=i-k){
                priorityQueue.poll();
            }
            ans[i-k+1]=priorityQueue.peek()[0];
        }
        return ans;
    }
    


    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int [] ans = maxSlidingWindow(nums,3);
        for(Integer ele : ans ){
            System.out.print(ele + " ");
        }
    }

}
