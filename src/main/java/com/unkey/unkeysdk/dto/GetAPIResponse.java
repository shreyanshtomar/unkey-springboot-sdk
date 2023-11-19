package com.unkey.unkeysdk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GetAPIResponse {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String workspaceId;
}
