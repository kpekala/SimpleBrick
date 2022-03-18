package kpekala.simplebrick;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kpekala.simplebrick.model.SetResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class SetRepository {
    private RestService restService = new RestService(new RestTemplateBuilder());

    public SetResponse fetchSet(String id) throws Throwable {
        String jsonResponse = restService.getSetWithResponseHandling(id+"-1");
        return processJson(jsonResponse);
    }

    private SetResponse processJson(String jsonResponse) throws Throwable {
        if (jsonResponse == null){
            throw new Throwable();
        }
        SetResponse modelResponse = new ObjectMapper().readValue(jsonResponse,SetResponse.class);
        return modelResponse;
    }

    public SetResponse fetchBestSet(String theme) throws Throwable {
        String jsonResponse = restService.getBestSetWithResponseHandling(theme);
        return processJson(jsonResponse);

    }
}
