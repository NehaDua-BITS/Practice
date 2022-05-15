package lld.ratelimiter.service;

import lld.ratelimiter.models.Request;

public interface RateLimiter {

    boolean isAllowed(Request request);

}
