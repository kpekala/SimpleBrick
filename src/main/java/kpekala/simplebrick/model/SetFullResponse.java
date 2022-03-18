package kpekala.simplebrick.model;

public class SetFullResponse {
    private SetModel setModel;
    private SetModel bestSet;

    public SetFullResponse(){}

    public SetFullResponse(SetModel setModel, SetModel bestSet) {
        this.setModel = setModel;
        this.bestSet = bestSet;
    }

    public SetModel getSetModel() {
        return setModel;
    }

    public void setSetModel(SetModel setModel) {
        this.setModel = setModel;
    }

    public SetModel getBestSet() {
        return bestSet;
    }

    public void setBestSet(SetModel bestSet) {
        this.bestSet = bestSet;
    }
}
