package lld.ratelimiter;

import lld.ratelimiter.models.Request;
import lld.ratelimiter.models.User;
import lld.ratelimiter.service.impl.FixedWindowRateLimiter;
import lld.ratelimiter.service.impl.LeakyBucketRateLimiter;
import lld.ratelimiter.service.impl.SlidingWindowRateLimiter;
import lld.ratelimiter.service.impl.TokenBucketRateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
//        application.testFixedWindowAlgo();
//        application.testSlidingWindowAlgo();
//        application.testLeakyBucket();
        application.testTokenBucket();
    }

    private void testTokenBucket() {
        User user1 = new User("TokenBucketUser");
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(10, 1);

        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 1; i <= 12; i++) {
            executorService.execute(() -> tokenBucketRateLimiter.isAllowed(new Request(user1.getId())));
        }
        executorService.shutdown();
    }

    private void testLeakyBucket() {
        User user1 = new User("LeakyBucketUser");
        LeakyBucketRateLimiter leakyBucketRateLimiter = new LeakyBucketRateLimiter(5);

        ExecutorService executorService = Executors.newFixedThreadPool(12);

        for (int i = 1; i <= 12; i++) {
            executorService.execute(() -> leakyBucketRateLimiter.isAllowed(new Request(user1.getId())));
        }

        executorService.shutdown();
    }

    private void testSlidingWindowAlgo() {
        User user1 = new User("SlidingWindowUser");
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(10, 1);

        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 1; i <= 12; i++) {
            executorService.execute(() -> slidingWindowRateLimiter.isAllowed(new Request(user1.getId())));
        }

        executorService.shutdown();
    }

    private void testFixedWindowAlgo() {
        User user1 = new User("FixedWindowUser");
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(5, 1);

        //todo: fix parallel calls
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 1; i <= 12; i++) {
            executorService.execute(() -> fixedWindowRateLimiter.isAllowed(new Request(user1.getId())));
        }
        executorService.shutdown();

        //sequential call
//        for (int i = 1; i <= 12; i++) {
//            fixedWindowRateLimiter.isAllowed(new Request(user1.getId()));
//        }
    }
}
