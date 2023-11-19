package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.unkey.unkeysdk.Constants.UNKEY_API_URL;

@Service
@Slf4j
public class KeyService implements IKeyService{
    private static final Logger logger = LoggerFactory.getLogger(KeyService.class);

    @Override
    public KeyCreateResponse createKey(KeyCreateRequest keyCreateRequest, String authToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<KeyCreateRequest> requestEntity = new HttpEntity<>(keyCreateRequest, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Send the HTTP request
            ResponseEntity<KeyCreateResponse> responseEntity = restTemplate.postForEntity(
                    UNKEY_API_URL + "/keys",
                    requestEntity,
                    KeyCreateResponse.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                log.error("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                log.error("Response body: " + responseEntity.getBody());
                log.error("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        } catch (Exception e) {
            // Handle other exceptions
            log.error("Error creating key: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public KeyVerifyResponse verifyKey(KeyVerifyRequest keyVerifyRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<KeyVerifyRequest> requestEntity = new HttpEntity<>(keyVerifyRequest, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Send the HTTP request
            ResponseEntity<KeyVerifyResponse> responseEntity = restTemplate.postForEntity(
                    UNKEY_API_URL + "/keys/verify",
                    requestEntity,
                    KeyVerifyResponse.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                log.error("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                log.error("Response body: " + responseEntity.getBody());
                log.error("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        }catch (Exception e) {
            // Handle other exceptions
            log.error("Error creating key: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ResponseEntity<String> updateKey(Map<String, Object> fieldsToUpdate, String authToken, String keyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(fieldsToUpdate, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Send the HTTP request
            ResponseEntity<KeyUpdateResponse> responseEntity = restTemplate.exchange(
                    UNKEY_API_URL + "/keys/" + keyId,
                    HttpMethod.PUT,
                    requestEntity,
                    KeyUpdateResponse.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("OK");
            } else {
                log.error("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                log.error("Response body: " + responseEntity.getBody());
                log.error("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        }
        catch (Exception e) {
            // Handle other exceptions
            log.error("Error creating key: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ResponseEntity<String> deleteKey(String authToken, KeyDeleteRequest keyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);

        String keyIdValue = keyId.getKeyId();
        String url = UNKEY_API_URL + "/keys/" + keyIdValue;

        try {
            // Send the HTTP request
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.DELETE,
                    requestEntity,
                    String.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("OK");
            } else {
                log.error("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                log.error("Response body: " + responseEntity.getBody());
                log.error("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        } catch (Exception e) {
            // Handle other exceptions
            log.error("Error creating key: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
