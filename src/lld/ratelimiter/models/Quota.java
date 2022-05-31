package lld.ratelimiter.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quota {
    private int maxTokens;
    private int tokenRefreshRate;
}
