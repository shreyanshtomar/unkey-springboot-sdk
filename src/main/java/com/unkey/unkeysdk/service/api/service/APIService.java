package com.unkey.unkeysdk.service.api.service;

import com.unkey.unkeysdk.dto.GetAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.unkey.unkeysdk.Constants.UNKEY_API_URL;

@Slf4j
@Service
public class APIService implements IAPIService{

    @Override
    public GetAPIResponse getAPI(String apiId, String authToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.setBearerAuth(authToken);
        String url = UNKEY_API_URL + "/apis/" + apiId;

        RestTemplate restTemplate = new RestTemplate();

        try{
            HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<GetAPIResponse> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    GetAPIResponse.class
            );

            if(responseEntity.getStatusCode().is2xxSuccessful()){
                return responseEntity.getBody();
            } else {
                log.error("Error getting API. Status code: " + responseEntity.getStatusCodeValue());
                log.error("Response body: " + responseEntity.getBody());
                log.error("Request headers: " + httpHeaders);

                throw new RuntimeException("Error getting API. See logs for details.");
            }
        } catch (Exception e){
            log.error("Error getting API: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
