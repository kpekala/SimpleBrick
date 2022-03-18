package kpekala.simplebrick;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kpekala.simplebrick.model.SetFullResponse;
import kpekala.simplebrick.model.SetModel;
import kpekala.simplebrick.model.SetResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private RestService restService = new RestService(new RestTemplateBuilder());

    private SetPresenter setPresenter = new SetPresenter();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/api/set")
    @ResponseBody
    public SetResponse getSet(@RequestParam String id){
        String jsonResponse = restService.getSetWithResponseHandling(id+"-1");
        if (jsonResponse == null){
            return null;
        }
        try {
            SetResponse modelResponse = new ObjectMapper().readValue(jsonResponse,SetResponse.class);
            return modelResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/full")
    @ResponseBody
    public SetFullResponse getFullData(@RequestParam String id){
        try {
            SetFullResponse response = setPresenter.onSetRequest(id);
            return response;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


}