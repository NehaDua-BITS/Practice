package random;

public class ExecutionTime {

    public static void main(String[] args) {
        ExecutionTime obj = new ExecutionTime();
        int n = 5;

        long startMt = System.currentTimeMillis();
        long startNt = System.nanoTime();
        obj.sample(n);
        long endMt = System.currentTimeMillis();
        long endNt = System.nanoTime();

        System.out.println("Execution time in ms = " + (endMt - startMt));
        System.out.println("Execution time in ns = " + (endNt - startNt));
    }

    private void sample(int n) {
        for (int i = 0; i < n; i++) {
            n += i;
        }
    }
}
