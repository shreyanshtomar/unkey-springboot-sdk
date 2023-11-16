package com.unkey.unkeysdk.controller;

import com.unkey.unkeysdk.dto.KeyCreateRequest;
import com.unkey.unkeysdk.dto.KeyCreateResponse;
import com.unkey.unkeysdk.dto.KeyVerifyRequest;
import com.unkey.unkeysdk.dto.KeyVerifyResponse;
import com.unkey.unkeysdk.service.key.service.IKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/unkeysdk", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnkeySdkController {
    private final IKeyService keyService;

    @PostMapping("/createKey")
    public KeyCreateResponse createKey(
            @RequestBody KeyCreateRequest keyCreateRequest,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return keyService.createKey(keyCreateRequest, authToken);
    }

    @PostMapping("/createKey/verify")
    public KeyVerifyResponse verifyKey(
            @RequestBody KeyVerifyRequest keyVerifyRequest,
            @RequestHeader("Authorization") String authToken) {
        // Delegate the creation of the key to the KeyService
        return keyService.verifyKey(keyVerifyRequest);
    }
}
