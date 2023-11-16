package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.KeyCreateRequest;
import com.unkey.unkeysdk.dto.KeyCreateResponse;

public interface IKeyService {
    KeyCreateResponse createKey(KeyCreateRequest keyCreateRequest, String authToken);
}
