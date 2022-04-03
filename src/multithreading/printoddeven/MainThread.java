package multithreading.printoddeven;

public class MainThread {

    public static void main(String[] args) {
        State state = new State(PrintType.ODD);

        Printer oddPrinter = new Printer(1, 20, state, PrintType.ODD, PrintType.EVEN);
        Printer evenPrinter = new Printer(2, 20, state, PrintType.EVEN, PrintType.ODD);
        Thread oddThread = new Thread(oddPrinter, "odd");
        Thread evenThread = new Thread(evenPrinter, "even");

        oddThread.start();
        evenThread.start();

//        for (int i : Arrays.asList(3,4,5,6)) {
//            SubThread subThread = new SubThread(i);
//            subThread.start();
//        }
    }

}
