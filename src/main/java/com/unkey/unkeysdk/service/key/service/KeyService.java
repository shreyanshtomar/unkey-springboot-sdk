package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.KeyCreateRequest;
import com.unkey.unkeysdk.dto.KeyCreateResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.unkey.unkeysdk.Constants.UNKEY_API_URL;

@Service
public class KeyService implements IKeyService{

    @Override
    public KeyCreateResponse createKey(KeyCreateRequest keyCreateRequest, String authToken) {
        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP request entity
        HttpEntity<KeyCreateRequest> requestEntity = new HttpEntity<>(keyCreateRequest, headers);

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send the HTTP request
        ResponseEntity<KeyCreateResponse> responseEntity = restTemplate.postForEntity(
                UNKEY_API_URL + "/keys",
                requestEntity,
                KeyCreateResponse.class
        );

        // Handle the response
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Response is successful, return the response body
            return responseEntity.getBody();
        } else {
            // Handle error response
            throw new RuntimeException("Error creating key: " + responseEntity.getStatusCodeValue());
        }
    }
}
