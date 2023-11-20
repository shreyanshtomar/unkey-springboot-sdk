package com.unkey.unkeysdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyVerifyResponse {
    @NonNull
    private Boolean valid;
    private String code;
    private String ownerId;
    private Long expires;
    private Object meta;
    private KeyVerifyRateLimit ratelimit;
    private Long remaining;
}
