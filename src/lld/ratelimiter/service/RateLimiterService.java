package lld.ratelimiter.service;

import lld.ratelimiter.models.Request;

public interface RateLimiterService {
    boolean isAllowed(Request request);
}
