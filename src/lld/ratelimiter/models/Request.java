package lld.ratelimiter.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Request {
    private String id;
    private String userId;
    //other attributes like DTO, headers, etc will be also there

    public Request(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }

}
