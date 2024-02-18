package com.codigo.msapazamamani.infraestructure;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReniecClient {

    private static final String BASE_URL = "https://dniruc.apisperu.com/api/v1/dni/%s";

    private final OkHttpClient httpClient;
    private final Gson gson;

    public ReniecClient(OkHttpClient httpClient, Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public ReniecResponse getPersonaByDni(String dni) throws IOException {
        Request request = new Request.Builder()
                .url(String.format(BASE_URL, dni))
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            ReniecResponse reniecResponse = gson.fromJson(responseBody, ReniecResponse.class);
            return reniecResponse;
        }
    }
}