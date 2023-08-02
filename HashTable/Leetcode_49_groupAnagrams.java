import java.util.*;

public class Leetcode_49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            String change = change(strs[i]);
            if(map.containsKey(change)){
                map.get(change).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(change,list);
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            lists.add(entry.getValue());
        }

        return lists;
    }

    public String change(String strs){
        char [] chars = strs.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }



}
