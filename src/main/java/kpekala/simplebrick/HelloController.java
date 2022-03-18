package kpekala.simplebrick;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kpekala.simplebrick.RestService;
import kpekala.simplebrick.SetPresenter;
import kpekala.simplebrick.model.SetFullResponse;
import kpekala.simplebrick.model.SetResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final RestService restService = new RestService(new RestTemplateBuilder());

    private final SetPresenter setPresenter = new SetPresenter();

    @GetMapping("/")
    public String index() {
        return "Greetings from SimpleBrick!";
    }

    @GetMapping("/api/set")
    @ResponseBody
    public SetResponse getSet(@RequestParam String id){
        String jsonResponse = restService.getSetWithResponseHandling(id+"-1");
        try {
            return new ObjectMapper().readValue(jsonResponse,SetResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/api/full")
    @ResponseBody
    public SetFullResponse getFullData(@RequestParam String id){
        try {
            return setPresenter.onSetRequest(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


}