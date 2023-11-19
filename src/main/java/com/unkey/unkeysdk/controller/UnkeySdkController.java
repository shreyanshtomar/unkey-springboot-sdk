package com.unkey.unkeysdk.controller;

import com.unkey.unkeysdk.dto.*;
import com.unkey.unkeysdk.service.api.service.IAPIService;
import com.unkey.unkeysdk.service.key.service.IKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/unkeysdk", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnkeySdkController {
    private final IKeyService keyService;
    private final IAPIService apiService;

    @PostMapping("/createKey")
    public KeyCreateResponse createKey(
            @RequestBody KeyCreateRequest keyCreateRequest,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return keyService.createKey(keyCreateRequest, authToken);
    }

    @PostMapping("/verify")
    public KeyVerifyResponse verifyKey(
            @RequestBody KeyVerifyRequest keyVerifyRequest) {
        // Delegate the creation of the key to the KeyService
        return keyService.verifyKey(keyVerifyRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateKey(
            @RequestParam String keyId,
            @RequestBody Map<String, Object> keyUpdateRequest,
            @RequestHeader("Authorization") String authToken
    ) {
        // Delegate the creation of the key to the KeyService
        return keyService.updateKey(keyUpdateRequest, authToken, keyId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> updateKey(
            @RequestBody KeyDeleteRequest keyId,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return keyService.deleteKey(authToken, keyId);
    }

    @GetMapping("/get-apis")
    public GetAPIResponse getAPI(
            @RequestParam String apiId,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return apiService.getAPI(apiId, authToken);
    }
    @GetMapping("/keys")
    public ListKeysResponse listKeys(
            @RequestParam String apiId,
            @RequestBody(required = false) ListKeysRequest listKeyRquest,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return apiService.listKeys(listKeyRquest, apiId, authToken);
    }
}
