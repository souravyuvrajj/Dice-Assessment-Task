package com.example.dice;

import org.springframework.stereotype.Component;

@Component
public class ApiKeyContextHolder {

    private static final ThreadLocal<String> apiKeyHolder = new ThreadLocal<>();
    public static String getApiKey() {
        return apiKeyHolder.get();
    }

    public static void setApiKey(String apiKey) {
        apiKeyHolder.set(apiKey);
    }

    public static void clear() {
        apiKeyHolder.remove();
    }

}
