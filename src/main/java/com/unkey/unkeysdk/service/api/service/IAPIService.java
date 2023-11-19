package com.unkey.unkeysdk.service.api.service;

import com.unkey.unkeysdk.dto.GetAPIResponse;

public interface IAPIService {
    GetAPIResponse getAPI(String apiId, String authToken);
}
