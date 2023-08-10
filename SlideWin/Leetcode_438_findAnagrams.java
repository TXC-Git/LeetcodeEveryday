package SlideWin;

import java.util.*;

public class Leetcode_438_findAnagrams {

    /**
     * 方法一、滑动窗口，对于S和P字符串，分别定义sCount数组和pCount数组，
     * 统计其中每个字符的数量，通过两个count数组的比较判断是否字母异位词
     *
     */
//    public static List<Integer> findAnagrams(String s, String p) {
//
//        List<Integer> result = new ArrayList<>();
//        //对于S和P字符串，分别定义一个count数组，统计其中每个字符的数量
//        int [] sCount = new int[26];
//        int [] pCount = new int[26];
//        if(s.length()<p.length()){
//            return result;
//        }
//        for(int i = 0 ; i < p.length() ; i++){
//            ++pCount[p.charAt(i)-'a'];
//            ++sCount[s.charAt(i)-'a'];
//        }
//        //统计S中前p.length()个字符和P中全部字符
//
//        if(Arrays.equals(pCount,sCount)){
//            result.add(0);
//        }
//        //如果两个统计数组完全一致，说明S中0下标处为一个字母异位词
//        for(int i = 0 ; i < s.length()-p.length() ; i++){
//            //窗口向前滑动，更新sCount
//            --sCount[s.charAt(i)-'a'];
//            ++sCount[s.charAt(i+p.length())-'a'];
//            //和pCount比较，若相等，标记为字母异位词
//            if(Arrays.equals(sCount,pCount)){
//                result.add(i+1);
//            }
//        }
//        return result;
//    }

    /**
     * 方法二、滑动窗口改进，只使用一个Count数组，定义一个diff表示滑动窗口中与P子串不同字母个数
     *
     *
     */
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> ans = new ArrayList<>();
        //如果子串长度大于母串，返回空列表
        if(s.length()<p.length()){
            return ans;
        }
        int [] count = new int[26];

        int diff = 0;
        //diff和count数组一一对应，diff的数量等于count数组中的非零元素个数
        //通过p和s中字符的各自加减，把p和s字符串的前p.length个字符的差异映射到count数组中相应位置[0-25]
        for(int i = 0 ; i < p.length() ; i++){
            --count[p.charAt(i)-'a'];
            ++count[s.charAt(i)-'a'];
        }
        //通过count数组判断滑动串口和P中不同的字符数量
        for(int i = 0 ; i < 26 ; i++){
            if(count[i]!=0){
                diff++;
            }
        }
        //若diff为0，意味着位置为0的地方有异位词
        if(diff==0){
            ans.add(0);
        }

        //循环向后滑动窗口
        for(int i = 0 ; i < s.length()-p.length() ; i++){
            //左指针指向的值需要减去，当count为1时，需要更新diff信息，因为此后左指针指向位置为0，
            if(count[s.charAt(i)-'a']==1){
                diff--;
            //左指针指向的值需要加上，当count为0时，需要更新diff信息，因为此后左指针指向位置为0，
            }else if(count[s.charAt(i)-'a']==0){
                diff++;
            }
            //减去左指针指向的值
            --count[s.charAt(i)-'a'];
            if(count[s.charAt(i+p.length())-'a']==-1){
                diff--;
            }else if(count[s.charAt(i+p.length())-'a']==0){
                diff++;
            }
            ++count[s.charAt(i+p.length())-'a'];

            if(diff==0)
                ans.add(i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "bpaa";
        String p = "aa";
        List<Integer>res = findAnagrams(s,p);
        for(int ele : res){
            System.out.print(ele + " ");
        }
    }

}
