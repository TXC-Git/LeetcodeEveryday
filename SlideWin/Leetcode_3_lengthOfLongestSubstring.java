package SlideWin;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int leftIdx = 0;
        int rightIdx = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int n = s.length();
        while(rightIdx < n ){
            if(set.contains(s.charAt(rightIdx))){
                leftIdx++;
                rightIdx = leftIdx;
                set.clear();
            }
            set.add(s.charAt(rightIdx));
            maxLen = Math.max(maxLen,rightIdx-leftIdx+1);
            rightIdx++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }


}
