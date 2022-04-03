package multithreading;

public class SubThread extends Thread {

    public SubThread(int name) {
        super(String.valueOf(name));
    }

    public void run() {
        System.out.println("This is inherited thread : " + Thread.currentThread().getName());
    }

}
