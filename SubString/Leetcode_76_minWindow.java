public class Leetcode_76_minWindow {

    public static String minWindow(String s, String t) {

        int len = s.length();
        //初始化工作，定义两个频次记录数组，0-25记录a-z,26-51记录A-Z
        String ans = "";
        int [] sCnt = new int[60];
        int [] tCnt = new int[60];
        int typeOfDiff = 0;
        //记录子字符串t的所有字符频次，用typeOfDiff记录出现的字符种类
        for(char chr : t.toCharArray()){
            if(++tCnt[getIndex(chr)]==1)
                typeOfDiff++;
        }

        for(int i = 0 , j = 0 ; j < len ; j++){
            int jdx = getIndex(s.charAt(j));
            //双指针法，右指针j每次向后移一个，更新sCnt中字符频次，若更新后右指针指向的字符满足相等，typeOfDiff减一
            //当sCnt[i]>tCnt[i]时无需处理，typeOfDiff已经处理过
            if(++sCnt[jdx]==tCnt[jdx]) typeOfDiff--;
            //循环判断左指针是否可以后移
            while(i<j){
                int idx =getIndex(s.charAt(i));
                //满足条件sCnt[idx]>tCnt时，左值针可以后移，sCnt[idx]减一，i加一
                if(sCnt[idx]>tCnt[idx]&&--sCnt[idx]>=0)
                    i++;
                else //不满足条件时，必须退出循环
                    break;
            }
            if(typeOfDiff==0&&ans.length()==0||ans.length()>j-i+1)
                ans = s.substring(i,j+1);//substring左闭右开
        }

        return ans;
    }

    public static int getIndex(char c){
        return c>='A'&&c<='Z'?c-'A'+26:c-'a';
    }


    public static void main(String[] args) {
        String s = "ab", t = "a";
        String ans = minWindow(s,t);
        System.out.println(ans);
    }


}
