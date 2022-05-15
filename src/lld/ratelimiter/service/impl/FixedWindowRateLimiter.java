package lld.ratelimiter.service.impl;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.service.RateLimiter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Getter
@Setter
public class FixedWindowRateLimiter implements RateLimiter {

    private Logger logger = Logger.getLogger(FixedWindowRateLimiter.class.getName());

    private Map<String, AccessInfo> userAccessInfoMap;

    private int windowCapacity;

    private int windowDurationInSec;

    private Object lock;

    public FixedWindowRateLimiter(int windowCapacity, int windowDurationInSec) {
        this.windowCapacity = windowCapacity;
        this.windowDurationInSec = windowDurationInSec;
        this.userAccessInfoMap = new ConcurrentHashMap<>();
        this.lock = new Object();
    }

    @Override
    public boolean isAllowed(Request request) {
        synchronized (this.lock) {
            boolean isAllowed = false;
            long currentTime = System.currentTimeMillis();
            AccessInfo accessInfo = userAccessInfoMap.get(request.getUserId());
            if (accessInfo == null) {
                userAccessInfoMap.put(request.getUserId(), new AccessInfo(1, currentTime));
                isAllowed = true;
            } else {
                long elapsedTime = (currentTime - accessInfo.getStartTime()) / 1000; //to convert milliseconds to seconds
                if (elapsedTime >= windowDurationInSec) {
                    accessInfo.setStartTime(currentTime);
                    accessInfo.setAccessCount(1);
                    isAllowed = true;
                } else {
                    if (accessInfo.getAccessCount() < windowCapacity) {
                        accessInfo.incrementAccessCount();
                        isAllowed = true;
                    }
                }
            }
            logger.info(String.format("Request %s : %s", isAllowed ? "Accepted" : "Rejected", request));
            return isAllowed;
        }
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class AccessInfo {
    private int accessCount;
    private long startTime;

    public void incrementAccessCount() {
        this.accessCount++;
    }
}
