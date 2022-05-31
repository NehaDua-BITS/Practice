package lld.ratelimiter;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.models.User;
import lld.ratelimiter.service.RateLimiterService;
import lld.ratelimiter.service.impl.TokenBucketRateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    private static RateLimiterService rateLimiterService;

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.testTokenBucket();
    }

    private void testTokenBucket() {
        rateLimiterService = new TokenBucketRateLimiter();
        User user1 = new User("TokenBucketUser");
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 1; i <= 12; i++) {
            executorService.execute(() -> rateLimiterService.isAllowed(new Request(user1.getId())));
        }
        executorService.shutdown();
    }
}
