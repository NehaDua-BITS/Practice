package dsa.medium.array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.toString(obj.groupAnagrams(strs).toArray()));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        int length = strs.length;
        for (int i = 0; i < length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = Arrays.toString(arr);
            List<String> values = map.get(key);
            if (values == null) {
                values = new ArrayList<String>();
                map.put(key, values);
            }
            values.add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

}