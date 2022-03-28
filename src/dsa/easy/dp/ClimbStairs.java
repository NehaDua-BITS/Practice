package dsa.easy.dp;

import java.util.Arrays;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs obj = new ClimbStairs();
        int n = 44;
        int m = 2;
        //System.out.println(String.format("Number of ways to climb %d stairs = %d", n, obj.climbStairs(n)));
        System.out.println("Number of ways using DP = " + obj.climbStairsUsingDP(n));
        System.out.println("Generic number of ways = " + obj.climbStairsUsingDP(n, m));
        System.out.println("Generic Iterative => Number of Ways = " + obj.climbStairsGenericIterative(n, m));
    }

    //O(2^n)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    //O(n)
    private int climbStairsUsingDP(int n) {
        int[] memory = new int[n+1];
        Arrays.fill(memory, -1);

        return climbStairsUsingDP(n, memory);
    }

    private int climbStairsUsingDP(int n, int[] memory) {

        if (n <= 1) {
            memory[n] = 1;
            return 1;
        }

        if (memory[n] != -1) {
            return memory[n];
        }

        memory[n] = climbStairsUsingDP(n-1, memory) + climbStairsUsingDP(n-2, memory);
        return memory[n];
    }

    //O(n * m)
    private int climbStairsUsingDP(int n, int m) {
        int[] memory = new int[n+1];
        Arrays.fill(memory, -1);

        return climbStairsUsingDPGeneric(n, m, memory);
    }

    private int climbStairsUsingDPGeneric(int n, int m, int[] memory) {

        if (n <= 1) {
            memory[n] = 1;
            return 1;
        }

        if (memory[n] != -1) {
            return memory[n];
        }

        int count = 0;
        for (int j = 1; j <= m && j <=n; j++) {
            count = count + climbStairsUsingDPGeneric(n-j, m, memory);
        }
        memory[n] = count;

        return memory[n];
    }

    //O(n * m) Iterative approach
    private int climbStairsGenericIterative(int n, int m) {
        int[] memory = new int[n+1];
        Arrays.fill(memory, 0);

        memory[0] = 1;
        memory[1] = 1;

        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=m && j <= n; j++) {
                memory[i] += memory[i-j];
            }
        }

        return memory[n];
    }


}
