package DoublePointer;

public class Leetcode_11_maxArea {

    public static int maxArea(int[] height) {
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }
        int maxA = 0;
        int leftIdx = 0;
        int rightIdx = height.length-1;
        while(leftIdx<rightIdx){
            int area = (rightIdx-leftIdx)*Math.min(height[leftIdx],height[rightIdx]);
            if(height[leftIdx]<height[rightIdx]){
                leftIdx++;
            }else{
                rightIdx--;
            }
            maxA = Math.max(area,maxA);
        }
        return maxA;
    }

    public static void main(String[] args) {
        int [] height ={4,3,2,1,4};
        int result = maxArea(height);
        System.out.println(result);
    }
}
