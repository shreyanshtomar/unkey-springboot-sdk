package com.unkey.unkeysdk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Meta {
    private Map<String, String> meta;
}
