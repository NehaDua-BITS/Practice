package lld.ratelimiter.algorithms;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {

    private final int windowCapacity;

    private final int windowDurationInSec;

    private Queue<Long> requestTimeQueue; //to track each request of the user

    public SlidingWindow(int windowCapacity, int windowDurationInSec) {
        this.windowCapacity = windowCapacity;
        this.windowDurationInSec = windowDurationInSec;
        this.requestTimeQueue = new ConcurrentLinkedQueue<>();
    }
    @Override
    public synchronized boolean isAllowed() {
        boolean isAllowed = false;
        long currentTime = System.currentTimeMillis();
        checkAndUpdateTimestampQueue(currentTime);
        if (requestTimeQueue.size() < windowCapacity) {
            requestTimeQueue.add(currentTime);
            isAllowed = true;
        }
        return isAllowed;
    }

    private void checkAndUpdateTimestampQueue(long currentTime) {
        while (!requestTimeQueue.isEmpty()) {
            long elapsedTime = (currentTime - requestTimeQueue.peek())/1000;
            if (elapsedTime < windowDurationInSec) break;
            System.out.println("Removing older timestamp : " + requestTimeQueue.poll()); //remove older timestamps
        }
    }
}
