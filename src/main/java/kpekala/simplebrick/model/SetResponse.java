package kpekala.simplebrick.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetResponse implements Serializable {
    private SetModel[] sets;

    public SetResponse(){}

    public SetResponse(SetModel[] sets) {
        this.sets = sets;
    }

    public SetModel[] getSets() {
        return sets;
    }

    public void setSets(SetModel[] sets) {
        this.sets = sets;
    }
}
