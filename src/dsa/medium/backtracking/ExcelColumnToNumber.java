package dsa.medium.backtracking;

public class ExcelColumnToNumber {

    public static void main(String[] args) {
        ExcelColumnToNumber obj = new ExcelColumnToNumber();
        String title = "AZ";
        System.out.println("Title to number = " + obj.titleToNumber(title));
    }

    private int titleToNumber(String columnTitle) {
        int columnNum = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            columnNum += (columnTitle.charAt(length-i-1) - 'A' + 1) * Math.pow(26, i);
        }

        return columnNum;
    }

}
