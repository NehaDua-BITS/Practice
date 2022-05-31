package dsa.microsoft;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str = {"flower","flow","float"};
        String result = new LongestCommonPrefix().longestCommonPrefix(str);
        System.out.println("longest prefix = " + result);
    }

    public String longestCommonPrefix(String[] strs) {

        int numOfStrings = strs.length;

        int maxIndex = strs[0].length();;
        for (int i = 1; i < numOfStrings; i++) {
            int j = 0;
            while (j < strs[0].length() && j < strs[i].length()
                    && (strs[0].charAt(j) == strs[i].charAt(j)) ) {
                j++;
            }

            maxIndex = Math.min(maxIndex, j) ;
        }

        return strs[0].substring(0, maxIndex);
    }
}
