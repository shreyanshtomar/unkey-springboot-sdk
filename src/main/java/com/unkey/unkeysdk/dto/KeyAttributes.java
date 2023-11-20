package com.unkey.unkeysdk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyAttributes {
    private String id;
    private String apiId;
    private String workspaceId;
    private String start;
    private String name;
    private String ownerId;
    private Meta meta;
    private Long createdAt;
    private Long expires;
    private Integer remaining;
    private KeyRateLimit ratelimit;
}
