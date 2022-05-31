package lld.ratelimiter.algorithms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixedWindow implements RateLimiter {

    private final int windowCapacity;

    private final int windowDurationInSec;

    private int numOfRequests;

    private long windowStartTime;

    public FixedWindow(int windowCapacity, int windowDurationInSec) {
        this.windowCapacity = windowCapacity;
        this.windowDurationInSec = windowDurationInSec;
    }

    @Override
    public synchronized boolean isAllowed() {
        boolean isAllowed = false;
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - windowStartTime)/1000;

        if (elapsedTime >= windowDurationInSec) {
            windowStartTime = currentTime;
            numOfRequests = 1;
            isAllowed = true;
        } else {
            if (numOfRequests < windowCapacity) {
                numOfRequests++;
                isAllowed = true;
            }
        }
        return isAllowed;
    }


}