package dsa.medium.backtracking;

public class ExcelNumberToColumn {

    public static void main(String[] args) {
       ExcelNumberToColumn obj = new ExcelNumberToColumn();
        int num = 705;
        System.out.println(String.format("%d maps to column => %s", num, obj.numToColumn(num)));
    }

    private String numToColumn(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int rem = num % 26;
            num = num / 26;
            if (rem == 0) {
                sb.append("Z");
                num--;
            } else {
                sb.append((char)('A' + rem - 1));
            }
        }

        return sb.reverse().toString();
    }
}
