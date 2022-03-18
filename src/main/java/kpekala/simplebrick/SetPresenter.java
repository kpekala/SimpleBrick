package kpekala.simplebrick;

import kpekala.simplebrick.model.SetFullResponse;
import kpekala.simplebrick.model.SetModel;
import kpekala.simplebrick.model.SetResponse;

import java.util.Set;

public class SetPresenter {

    private SetRepository repository = new SetRepository();

    public SetFullResponse onSetRequest(String setID) throws Throwable {
        SetResponse response = repository.fetchSet(setID);
        SetFullResponse fullResponse = processSetResponse(response);
        return fullResponse;
    }

    private SetFullResponse processSetResponse(SetResponse response) throws Throwable {
        if(response.getSets().length == 0)
            return null;

        SetModel baseModel = response.getSets()[0];
        SetResponse bestSetResponse = repository.fetchBestSet(baseModel.getTheme());

        if(bestSetResponse.getSets().length == 0)
            return null;

        return new SetFullResponse(baseModel,bestSetResponse.getSets()[0]);
    }
}
