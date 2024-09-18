package com.inttao.npi.backend.util.security;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Auth0Utils {
    public static String getToken(String clientId, String clientSecret, String grantType, String tokenUri) throws URISyntaxException, IOException, InterruptedException {
        String token = null;
        StringBuilder body = new StringBuilder("client_id=" + clientId);
        body.append("&client_secret=" + clientSecret);
        body.append("&grant_type=" + grantType);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(tokenUri))
                .version(HttpClient.Version.HTTP_2)
                .header("content-type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map< String, Object > map = springParser.parseMap(responseBody);
        if (map.containsKey("access_token"))
            token = map.get("access_token").toString();

        return token;

    }

}
