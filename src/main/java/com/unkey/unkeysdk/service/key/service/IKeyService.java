package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.*;

public interface IKeyService {
    KeyCreateResponse createKey(KeyCreateRequest keyCreateRequest, String authToken);
    KeyVerifyResponse verifyKey(KeyVerifyRequest keyVerifyRequest);
}
