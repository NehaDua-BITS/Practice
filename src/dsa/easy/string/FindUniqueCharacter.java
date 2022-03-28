package dsa.easy.string;

public class FindUniqueCharacter {

    public static void main(String[] args) {

        FindUniqueCharacter obj = new FindUniqueCharacter();
        String s = "aabb";
        int index = obj.firstUniqChar(s);
        System.out.println("index = " + index);
    }

    private int firstUniqChar(String s) {
        int[] charCount = new int[26];

        int length = s.length();
        //count the occurance of a char in string
        for (int i = 0; i < length; i++) {
            charCount[s.charAt(i)-'a']++;
        }

        //find first non-repeated char
        for (int i = 0; i < length; i++) {
            if (charCount[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
