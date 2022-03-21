package kpekala.simplebrick;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kpekala.simplebrick.model.SetFullResponse;
import kpekala.simplebrick.model.SetResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "value= /api/set", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getSet(@RequestParam String id){
        String jsonResponse = restService.getSetWithResponseHandling(id+"-1");
        try {
            SetResponse response = new ObjectMapper().readValue(jsonResponse,SetResponse.class);
            return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                    "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

//    private String GetHTMLResponse(SetResponse response) {
//
//    }

    @GetMapping("/api/full")
    @ResponseBody
    public String getFullData(@RequestParam String id){
        try {
            SetFullResponse fullResponse = setPresenter.onSetRequest(id);
            HTMLResponse response = new HTMLResponse(fullResponse.getSetModel(), fullResponse.getBestSet());
            return response.parse();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


}