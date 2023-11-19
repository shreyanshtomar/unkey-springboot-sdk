package com.unkey.unkeysdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyCreateRequest {
    @NonNull
    private String apiId;
    private String prefix;
    private String name;
    private Integer byteLength;
    private String ownerId;
    private Meta meta;
    private Integer expires;
    private Integer remaining;
    private KeyRateLimit ratelimit;
}
