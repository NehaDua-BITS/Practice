package src;

import lld.ratelimiter.models.Quota;
import lld.ratelimiter.models.Request;
import lld.ratelimiter.models.User;
import lld.ratelimiter.service.QuotaService;
import lld.ratelimiter.service.impl.TokenBucketRateLimiter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRateLimiter {

    @Test
    public void testSample() throws ExecutionException, InterruptedException {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter();
        User user = new User("TestUser");

        int totalRequests = 12;
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        List<Future<Boolean>> futureList = new ArrayList<>(totalRequests);
        for (int i = 1; i <= totalRequests; i++) {
            futureList.add(executorService.submit(() -> rateLimiter.isAllowed(new Request(user.getId()))));
        }

        int accepted = 0;
        int rejected = 0;
        for (int i = 0; i < totalRequests; i++) {
            boolean result = futureList.get(i).get();
            if (result) {
                accepted++;
            } else {
                rejected++;
            }
        }

        Quota quota = QuotaService.getUserQuota(user.getId());
        Assert.assertEquals(quota.getMaxTokens(), accepted);
        Assert.assertEquals(totalRequests-quota.getMaxTokens(), rejected);
    }

    @Test
    public void testForMultipleUsers() throws ExecutionException, InterruptedException {
        User user1 = new User("u1");
        User user2 = new User("u2");
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter();

        List<Future<Boolean>> futureList1 = new ArrayList<>(12);
        List<Future<Boolean>> futureList2 = new ArrayList<>(12);

        int totalRequests = 12;
        ExecutorService executorService = Executors.newFixedThreadPool(totalRequests);
        for (int i = 0; i < totalRequests; i++) {
            futureList1.add(executorService.submit(() -> tokenBucketRateLimiter.isAllowed(new Request(user1.getId()))));
            futureList2.add(executorService.submit(() -> tokenBucketRateLimiter.isAllowed(new Request(user2.getId()))));
        }

        int[] count1 = new int[2];
        int[] count2 = new int[2];

        for (int i = 0; i < totalRequests; i++) {
            boolean r1 = futureList1.get(i).get();
            count1[r1 ? 0 : 1]++;
            boolean r2 = futureList2.get(i).get();
            count2[r2 ? 0 : 1]++;
        }

        Quota quota = QuotaService.getUserQuota(user1.getId());
        Assert.assertEquals(quota.getMaxTokens(), count1[0]);
        Assert.assertEquals(totalRequests - quota.getMaxTokens(), count1[1]);

        quota = QuotaService.getUserQuota(user2.getId());
        Assert.assertEquals(quota.getMaxTokens(), count2[0]);
        Assert.assertEquals(totalRequests - quota.getMaxTokens(), count2[1]);
    }


}
