package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    public static void taskFourMain() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://httpbin.org/get")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Response status code is " + response.statusCode());
                return;
            }

            var responseJson = response.body();
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                Response deserializedJson = objectMapper.readValue(responseJson, Response.class);
                System.out.println("Host: " + deserializedJson.getHeaders().getHost());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private Headers headers;

        @JsonProperty("headers")
        public Headers getHeaders() {
            return headers;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Headers {
            @JsonProperty("Host")
            private String host;

            public String getHost() {
                return host;
            }
        }
    }
}