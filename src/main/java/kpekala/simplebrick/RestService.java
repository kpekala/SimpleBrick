package kpekala.simplebrick;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final String apiKey = "3-Hm1r-1oyZ-oFVzp";
    private final String userHash = "B5YVv7ynbh";
    private final String baseURL = "https://brickset.com/api/v3.asmx";

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getSetWithResponseHandling(String number) {
        String params = String.format("{\"setNumber\":\"%s\"}", number);
        return fetchSets(params);
    }

    public String getBestSetWithResponseHandling(String theme) {
        String params = String.format("{\"theme\":\"%s\"}", theme);
        return fetchSets(params);
    }

    private String fetchSets(String params) {
        String url = baseURL + String.format("/getSets?apiKey=%s&userHash=%s&params={params}",
                apiKey,userHash);
        System.out.println(url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url ,String.class,params);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}