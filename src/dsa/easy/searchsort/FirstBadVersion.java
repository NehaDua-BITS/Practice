package dsa.easy.searchsort;

public class FirstBadVersion {

    private int bad = 1702766719;
    private static int n = 2126753390;

    public static void main(String[] args) {
        System.out.println("Bad Version = " + new FirstBadVersion().firstBadVersion(n));
    }

    private int firstBadVersion(int n) {

        int start = 1, end = n;
        int mid = 0;
        while (start<=end) {
            mid = (int)(((long)start + end)/2);
            boolean isBadVersion = isBadVersion(mid);
            if (!isBadVersion) {
                start = mid+1;
            } else {
                if (!isBadVersion((int)mid-1)) {
                    return mid;
                }
                end = mid-1;;
            }
        }
        return mid;
    }

    private boolean isBadVersion(int version) {
        return version >= bad;
    }
}
