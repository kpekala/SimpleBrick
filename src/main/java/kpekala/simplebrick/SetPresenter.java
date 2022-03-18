package kpekala.simplebrick;

import kpekala.simplebrick.model.SetFullResponse;
import kpekala.simplebrick.model.SetModel;
import kpekala.simplebrick.model.SetResponse;

import java.util.Arrays;
import java.util.Comparator;

public class SetPresenter {

    private SetRepository repository = new SetRepository();

    public SetFullResponse onSetRequest(String setID) throws Throwable {
        SetResponse response = repository.fetchSet(setID);
        return processSetResponse(response);
    }

    private SetFullResponse processSetResponse(SetResponse response) throws Throwable {
        if(response.getSets().length == 0)
            return null;

        SetModel baseModel = response.getSets()[0];
        SetResponse bestSetResponse = repository.fetchBestSet(baseModel.getTheme());


        if(bestSetResponse.getSets().length == 0)
            return null;

        SetModel bestModel = getMostPopularModel(bestSetResponse.getSets());

        return new SetFullResponse(baseModel,bestModel);
    }

    private SetModel getMostPopularModel(SetModel[] sets){
        Arrays.sort(sets, Comparator.comparingInt(SetModel::getPieces));
        return sets[sets.length-1];
    }
}
