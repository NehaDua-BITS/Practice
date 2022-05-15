package lld.ratelimiter.service.impl;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.service.RateLimiter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TokenBucketRateLimiter implements RateLimiter {

    private Logger logger = Logger.getLogger(TokenBucketRateLimiter.class.getName());

    private int maxTokens; //max bucket capacity

    private int tokenRefreshRate; //token refresh interval

    private Map<String, UserTokenInfo> userTokenInfoMap;

    private Object lock;

    public TokenBucketRateLimiter(int maxTokens, int tokenRefreshRate) {
        this.maxTokens = maxTokens;
        this.tokenRefreshRate = tokenRefreshRate;
        userTokenInfoMap = new ConcurrentHashMap<>();
        lock = new Object();
    }

    @Override
    public boolean isAllowed(Request request) {
        synchronized (this.lock) {
            boolean isAllowed = false;
            long currentTime = System.currentTimeMillis();
            UserTokenInfo userTokenInfo = userTokenInfoMap.get(request.getUserId());
            if (userTokenInfo == null) {
                userTokenInfoMap.put(request.getUserId(), new UserTokenInfo(maxTokens - 1, currentTime));
                isAllowed = true;
            } else {
                refreshTokens(userTokenInfo, currentTime);
                if (userTokenInfo.getAvailTokens().get() > 0) {
                    userTokenInfo.getAvailTokens().decrementAndGet();
                    isAllowed = true;
                }
            }

            logger.info(String.format("Request %s : %s", isAllowed ? "Accepted" : "Rejected", request));
            return isAllowed;
        }
    }

    private void refreshTokens(UserTokenInfo userTokenInfo, long currentTime) {
        int additionalTokens = (int) (((currentTime - userTokenInfo.getLastTokenRefreshTime().get()) / 1000) * tokenRefreshRate);
        int newTokens = Math.min(userTokenInfo.getAvailTokens().get() + additionalTokens, maxTokens);
        userTokenInfo.getAvailTokens().getAndSet(newTokens);
        userTokenInfo.getLastTokenRefreshTime().getAndSet(currentTime);
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UserTokenInfo {
    private AtomicInteger availTokens;
    private AtomicLong lastTokenRefreshTime;

    public UserTokenInfo(int availTokens, long lastTokenRefreshTime) {
        this.availTokens = new AtomicInteger(availTokens);
        this.lastTokenRefreshTime = new AtomicLong(lastTokenRefreshTime);
    }
}