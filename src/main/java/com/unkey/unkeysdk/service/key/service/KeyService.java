package com.unkey.unkeysdk.service.key.service;

import com.unkey.unkeysdk.dto.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static com.unkey.unkeysdk.Constants.UNKEY_API_URL;

@Service
public class KeyService implements IKeyService{

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
                System.err.println("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                System.err.println("Response body: " + responseEntity.getBody());
                System.err.println("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        } catch (HttpClientErrorException e) {
            // Handle HTTP 4xx errors (client errors)
            System.err.println("Client error: " + e.getRawStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            System.err.println("Request headers: " + headers);
            e.printStackTrace();
            throw e;
        } catch (HttpServerErrorException e) {
            // Handle HTTP 5xx errors (server errors)
            System.err.println("Server error: " + e.getRawStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            System.err.println("Request headers: " + headers);
            System.err.println("Request Body: " + requestEntity.getBody());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error creating key: " + e.getMessage());
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
                System.err.println("Error creating key. Status code: " + responseEntity.getStatusCodeValue());
                System.err.println("Response body: " + responseEntity.getBody());
                System.err.println("Request headers: " + headers);

                // Throw a custom exception with more details
                throw new RuntimeException("Error creating key. See logs for details.");
            }
        }
        catch (HttpClientErrorException e) {
            // Handle HTTP 4xx errors (client errors)
            System.err.println("Client error: " + e.getRawStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            System.err.println("Request headers: " + headers);
            e.printStackTrace();
            throw e;
        } catch (HttpServerErrorException e) {
            // Handle HTTP 5xx errors (server errors)
            System.err.println("Server error: " + e.getRawStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            System.err.println("Request headers: " + headers);
            System.err.println("Request Body: " + requestEntity.getBody());
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error creating key: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

}
