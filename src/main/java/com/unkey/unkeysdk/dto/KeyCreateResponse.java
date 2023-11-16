package com.unkey.unkeysdk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class KeyCreateResponse {
    private String key;
    private String keyId;
}
