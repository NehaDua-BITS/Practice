package lld.ratelimiter.service.impl;

import lld.ratelimiter.algorithms.TokenBucket;
import lld.ratelimiter.models.Quota;
import lld.ratelimiter.models.Request;
import lld.ratelimiter.service.QuotaService;
import lld.ratelimiter.service.RateLimiterService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter implements RateLimiterService {

    private Map<String, TokenBucket> userBucketMap;

    public TokenBucketRateLimiter() {
        this.userBucketMap = new ConcurrentHashMap<>();
        //scheduleDeletion();
    }

    @Override
    public synchronized boolean isAllowed(Request request) {
        String userId = request.getUserId();
        TokenBucket userBucket = userBucketMap.computeIfAbsent(userId, id -> {
            System.out.println("Bucket created for user :" + userId);
            Quota userQuota = QuotaService.getUserQuota(userId);
            return new TokenBucket(userQuota.getMaxTokens(), userQuota.getTokenRefreshRate());
        });
        boolean isAllowed = userBucket.isAllowed();
        System.out.println(String.format("Request %s => %s", isAllowed ? "Accepted" : "Rejected", request));
        return isAllowed;
    }

//    private void scheduleDeletion() {
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(5);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            long thresholdTime = 2000;
//            for (Map.Entry<String, TokenBucket> entry : userBucketMap.entrySet()) {
//                if (System.currentTimeMillis() - entry.getValue().getLastTokenRefreshTime() >= thresholdTime) {
//                    userBucketMap.remove(entry.getKey());
//                }
//            }
//        }, 3, 1, TimeUnit.SECONDS);
//    }
}

