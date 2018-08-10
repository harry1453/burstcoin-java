package com.harry1453.burst.test.mock;

import com.harry1453.burst.explorer.service.NetworkService;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.NotNull;

import io.reactivex.Single;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MockNetworkService implements NetworkService {

    private final HttpClient httpClient = HttpClientBuilder.create().build();

    @NotNull
    @Override
    public Single<String> fetchData(@NotNull String url) {
        return Single.fromCallable(() -> {
            HttpGet request = new HttpGet(url);
            request.addHeader("User-Agent", "Burstcoin-Java");
            HttpResponse response = httpClient.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        });
    }
}
