package random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\s");
        String str = "how are you?";
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.replaceAll(":"));


        String s = "A man;, !a -pl+an, a canal: Panama";
        String regex = "[^\\w]";
        String result = s.replaceAll(regex, "").toLowerCase();
        System.out.println("Replaced string = " + result);
    }
}
