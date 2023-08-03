package DoublePointer;

import java.util.Collections;



public class Leetcode_283_moveZeroes {

    public static void moveZeroes(int[] nums) {
        int leftIdx = 0;
        int rightIdx = 0;
        while(rightIdx<nums.length){
            if(nums[rightIdx]!=0){
                swap(nums,leftIdx,rightIdx);
                leftIdx++;
            }
            rightIdx++;
        }
    }



    public static void swap(int [] array , int leftIdx , int rightIdx){
        int temp = 0 ;
        temp = array[leftIdx];
        array[leftIdx]=array[rightIdx];
        array[rightIdx]=temp;
    }

    public static void main(String[] args) {
        int [] nums = {-1, 1, 0, 3, 12};
        moveZeroes(nums);
        for(Integer num : nums){
            System.out.print(num+" ");
        }
    }

}
