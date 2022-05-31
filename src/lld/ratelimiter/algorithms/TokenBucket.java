package lld.ratelimiter.algorithms;

import lombok.Getter;

@Getter
public class TokenBucket implements RateLimiter {

    private final int maxTokens; //max bucket capacity

    private final int tokenRefreshRate;

    private int availableTokens;

    private long lastTokenRefreshTime;

    public TokenBucket(int maxTokens, int tokenRefreshRate) {
        this.maxTokens = maxTokens;
        this.tokenRefreshRate = tokenRefreshRate;
        this.availableTokens = maxTokens;
        this.lastTokenRefreshTime = System.currentTimeMillis();
    }

    @Override
    public boolean isAllowed() {
        boolean isAllowed = false;
        long currentTime = System.currentTimeMillis();
        refreshTokens(currentTime);
        if (availableTokens > 0) {
            availableTokens--;
            isAllowed = true;
        }
        return isAllowed;
    }

    private void refreshTokens(long currentTime) {
        int additionalTokens = (int) (((currentTime - lastTokenRefreshTime) / 1000) * tokenRefreshRate);
        availableTokens = Math.min(availableTokens + additionalTokens, maxTokens);
        lastTokenRefreshTime = currentTime;
    }
}
