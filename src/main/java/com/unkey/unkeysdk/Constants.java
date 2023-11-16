package com.unkey.unkeysdk;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    private static final String UNKEY_API_VERSION = "v1";
    private static final String UNKEY_BASE_URL = "https://api.unkey.dev";
    public static final String UNKEY_API_URL = UNKEY_BASE_URL + "/" + UNKEY_API_VERSION;
}
