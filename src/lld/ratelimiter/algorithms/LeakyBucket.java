package lld.ratelimiter.algorithms;

public class LeakyBucket implements RateLimiter {

    private final int bucketCapacity;

    private int currentCapacity;

    public LeakyBucket(int bucketCapacity) {
        this.bucketCapacity = bucketCapacity;
    }

    @Override
    public synchronized boolean isAllowed() {
        boolean isAllowed = true;
        if (currentCapacity < bucketCapacity) {
            currentCapacity++;
            isAllowed = true;
        }
        return isAllowed;
    }
}
