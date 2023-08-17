package NormalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_56_merge {

    public static int[][] merge(int[][] intervals) {
        //对intervals数组进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int j = 0;
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i = 1 ; i < intervals.length ; i++){
            if(list.get(j)[1]<intervals[i][0]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
                j++;
            }
            else {
                list.set(j,new int[]{list.get(j)[0],Math.max(intervals[i][1],list.get(j)[1])});
            }
        }
        int [][] ans = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {

        int [][] nums = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int [][] res = merge(nums);
        for(int [] a : res){
            for(int b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
