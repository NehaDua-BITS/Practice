package lld.ratelimiter.service.impl;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.service.RateLimiter;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class SlidingWindowRateLimiter implements RateLimiter {

    private Logger logger = Logger.getLogger(SlidingWindowRateLimiter.class.getName());

    private int windowCapacity;

    private int windowDurationInSec;

    private Map<String, Queue<Long>> userAccessTimestampsMap; //to track each request of the user

    private Object lock;

    public SlidingWindowRateLimiter(int windowCapacity, int windowDurationInSec) {
        this.windowCapacity = windowCapacity;
        this.windowDurationInSec = windowDurationInSec;
        this.userAccessTimestampsMap = new ConcurrentHashMap<>();
        this.lock = new Object();
    }

    @Override
    public boolean isAllowed(Request request) {
        synchronized (this.lock) {
            long currentTimestamp = System.currentTimeMillis();
            Queue<Long> timestampsQueue = userAccessTimestampsMap.getOrDefault(request.getUserId(), new ConcurrentLinkedQueue<>());
                checkAndUpdateTimestampQueue(timestampsQueue, currentTimestamp);
                if (timestampsQueue.size() < windowCapacity) {
                    timestampsQueue.offer(currentTimestamp);
                    userAccessTimestampsMap.put(request.getUserId(), timestampsQueue);
                    logger.info("Request Accepted : " + request);
                    return true;
                }

            logger.info("Request Rejected : " + request);
            return false;
        }
    }

    private void checkAndUpdateTimestampQueue(Queue<Long> queue, long currentTimestamp) {
        while (!queue.isEmpty()) {
            long elapsedTime = (currentTimestamp - queue.peek())/1000;
            if (elapsedTime < windowDurationInSec) break;
            System.out.println("Removing older timestamp : " + queue.poll());
        }
    }
}
