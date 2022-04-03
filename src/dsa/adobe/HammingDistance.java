package dsa.adobe;

public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        int x = 2;
        int y = 4;
        int dist = obj.hammingDistance(x, y);
        System.out.println(String.format("Hamming Distance between %d and %d = %d", x, y, dist));
    }

    public int hammingDistance(int x, int y) {

        int distance = 0;
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);

        int xIndex = xStr.length()-1;
        int yIndex = yStr.length()-1;
        for (; xIndex >=0 && yIndex >=0; xIndex--, yIndex--) {
            if (xStr.charAt(xIndex) != yStr.charAt(yIndex)) {
                distance++;
            }
        }

       distance += findSetBits(xStr, xIndex);
       distance += findSetBits(yStr, yIndex);

       return distance;
    }

    private int findSetBits(String str, int index) {
        int count = 0;
        while (index >= 0) {
            if (str.charAt(index) == '1') {
                count++;
            }
            index--;
        }
        return count;
    }
}
