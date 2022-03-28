package dsa.easy.string;

public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ell";
        StrStr obj = new StrStr();
//        System.out.println("Index = " + obj.strStr(haystack, needle));
        System.out.println("Index = " + obj.strStrOptimised(haystack, needle));

    }

    private int strStrOptimised(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        if (hLength < nLength) {
            return -1;
        }

        StringBuilder searchStr = new StringBuilder(haystack.substring(0, nLength-1));
        for (int i=nLength-1; i < hLength; i++) {

            searchStr.append(haystack.charAt(i));

            if (searchStr.toString().equals(needle)) {
                return i-nLength+1;
            }

            searchStr.deleteCharAt(0); //using sliding window technique
        }

        return -1;
    }

    //time limit exceeded
    private int strStr(String haystack, String needle) {
        int result = -1;

        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        if (hLength < nLength) {
            return -1;
        }

        for (int i = 0; i <= hLength-nLength; i++) {
            //if 1st character matched, compare remaining
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                int k= 1;
                for (int j = i + 1; k < nLength; j++, k++) {
                    if (haystack.charAt(j) != needle.charAt(k)) {
                        found = false;
                        break;
                    }
                }

                if (found && k >= nLength) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }

}
