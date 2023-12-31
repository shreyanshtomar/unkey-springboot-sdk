package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IKeyService {
    KeyCreateResponse createKey(KeyCreateRequest keyCreateRequest, String authToken);
    KeyVerifyResponse verifyKey(KeyVerifyRequest keyVerifyRequest);
    ResponseEntity<String> updateKey(Map<String, Object> fieldsToUpdate, String authToken, String keyId);
    ResponseEntity<String> deleteKey(String authToken, KeyDeleteRequest keyId);
}
