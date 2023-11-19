package com.unkey.unkeysdk.service.api.service;

import com.unkey.unkeysdk.dto.GetAPIResponse;
import com.unkey.unkeysdk.dto.ListKeysRequest;
import com.unkey.unkeysdk.dto.ListKeysResponse;

public interface IAPIService {
    GetAPIResponse getAPI(String apiId, String authToken);
    ListKeysResponse listKeys(ListKeysRequest listKeyRquest, String apiId, String authToken);

}
