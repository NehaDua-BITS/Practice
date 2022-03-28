package dsa.medium.array;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        int n = 4;
        System.out.println("Count and Say String = " + obj.countAndSay(n));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = "1";
        for (int i = 2; i <= n; i++) {
            prev = say(prev);
        }

        return prev;
    }

    private String say(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        int count = 0;
        int i = 0;
        for (; i < length; i++) {
            if (i == 0) {
                count++;
            } else {
                if (str.charAt(i) == str.charAt(i-1)) {
                    count++;
                } else {
                    sb.append(count).append(str.charAt(i-1));
                    count = 1;
                }
            }
        }

        if (count > 0) {
            sb.append(count).append(str.charAt(i-1));
        }

        return sb.toString();
    }
}
