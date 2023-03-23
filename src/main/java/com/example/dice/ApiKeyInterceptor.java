package com.example.dice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-RapidAPI-Key";
    private static final String APPLICATION_ID_HEADER = "X-Application-ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader(API_KEY_HEADER);

        if (apiKey == null || apiKey.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "API key missing");
            return false;
        }

        ApiKeyContextHolder.setApiKey(apiKey);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // clear the API key from the context after the request is completed
        ApiKeyContextHolder.clear();
    }

}