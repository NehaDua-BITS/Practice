package lld.ratelimiter.service;

import lld.ratelimiter.models.Quota;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuotaService {

    private static Map<String, Quota> quotaMap;

    private static Quota defaultQuota;

    static {
        quotaMap = new ConcurrentHashMap<>();
        defaultQuota = new Quota(5, 5);
    }

    public static Quota getUserQuota(String userId) {
        return quotaMap.getOrDefault(userId, defaultQuota);
    }

    public static synchronized void addUserQuota(String userId, int numOfRequests, int periodInSec) {
        quotaMap.put(userId, new Quota(numOfRequests, periodInSec));
    }
}
