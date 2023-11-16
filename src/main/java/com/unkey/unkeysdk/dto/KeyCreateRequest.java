package com.unkey.unkeysdk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class KeyCreateRequest {
    private String apiId;
    private String prefix;
    private String name;
    private int byteLength;
    private String ownerId;
    private Meta meta;
    private int expires;
    private int remaining;
    private KeyRateLimit ratelimit;
}
