package lld.ratelimiter.service.impl;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.service.RateLimiter;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class LeakyBucketRateLimiter implements RateLimiter {

    private Logger logger = Logger.getLogger(LeakyBucketRateLimiter.class.getName());

    private int capacity; //assuming all users have same capacity

    private Map<String, BlockingQueue<Request>> userBucketMap;

    private Object lock;

    public LeakyBucketRateLimiter(int capacity) {
        this.capacity = capacity;
        userBucketMap = new ConcurrentHashMap<>();
        this.lock = new Object();
    }

    @Override
    public boolean isAllowed(Request request) {
        synchronized (this.lock) {
            BlockingQueue<Request> userBucket = userBucketMap.get(request.getUserId());
            if (userBucket == null) {
                userBucket = new LinkedBlockingQueue<>(capacity);
                userBucketMap.put(request.getUserId(), userBucket);
            }
            if (userBucket.size() < capacity) {
                userBucket.add(request);
                logger.info("Request Accepted : " + request);
                return true;
            }

            logger.info("Request Rejected : " + request);
            return false;
        }
    }
}
