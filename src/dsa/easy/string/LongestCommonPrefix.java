package dsa.easy.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest Common Prefix : " + obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        int numOfStrings = strs.length;

        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < numOfStrings; i++) {
                if (strs[i].length() <= j || (strs[i].charAt(j) != strs[0].charAt(j))) {
                    return sb.toString();
                }
            }

            sb.append(strs[0].charAt(j));
        }

        return sb.toString();
    }

}
