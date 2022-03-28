package dsa.easy.others;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        int x = 3;
        System.out.println(String.format("Number after Reversing Bits of %d = %s", x, obj.reverseBits(x)));
    }

    private int reverseBits(int n) {
        String binary = getBinaryString(n);
        StringBuilder sb = new StringBuilder(binary);

        for (int i = 0, j = sb.length()-1; i < j; i++, j--) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }

        System.out.println("Reversed binary string = " + sb);

        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    private String getBinaryString(int n) {
        String str = Integer.toUnsignedString(n, 2);
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 32-str.length(); i++) {
            sb.append('0');
        }
        sb.append(str);

        System.out.println("Binary String = " + sb);
        return sb.toString();
    }

}
