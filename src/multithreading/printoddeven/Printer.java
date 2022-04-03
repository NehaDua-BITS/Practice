package multithreading.printoddeven;

import lombok.SneakyThrows;

public class Printer implements Runnable {

    private int currentVal;

    private int max;

    private State state;

    private PrintType selfPrintType;

    private PrintType nextPrintType;

    public Printer(int startValue, int max, State state, PrintType printType, PrintType nextPrintType) {
        this.currentVal = startValue;
        this.max = max;
        this.state = state;
        this.selfPrintType = printType;
        this.nextPrintType = nextPrintType;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (currentVal <= max) {
            synchronized (state) {
                while (state.getPrintType() != this.selfPrintType) {
                    state.wait();
                }
                System.out.println(Thread.currentThread().getName() + " : " + selfPrintType + " => " + currentVal);
                currentVal += 2;
                state.setPrintType(nextPrintType);
                state.notifyAll();
            }
        }
    }
}
