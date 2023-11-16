package com.unkey.unkeysdk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class KeyRateLimit {
    private String type;
    private Integer limit;
    private Integer refillRate;
    private Integer refillInterval;
}
