package kpekala.simplebrick;

import kpekala.simplebrick.model.SetModel;

public class HTMLResponse {
    private SetModel setModel;
    private SetModel bestModel;
    public HTMLResponse(SetModel setModel, SetModel bestModel){
        this.setModel = setModel;
        this.bestModel = bestModel;
    }

    public String parse(){
        return "<html>\n"
                + parseHeader("SimpleBrick")
                + parseBody()
                +  "</html>";
    }

    private String parseBody(){
        return "<body>\n"
                + parseSet(setModel)
                + "<b>Biggest set from theme " + setModel.getTheme() + ": </b>\n"
                + parseSet(bestModel)
                + "</body>\n";
    }

    private String parseSet(SetModel model){
        return "<b>" + model.getName() + "</b><br>"
                + "Theme: " + model.getTheme() + "<br>"
                + "Pieces: " + model.getPieces() + "<br>"
                + parseImage(model.getImage().getThumbnailURL());
    }

    private String parseImage(String url){
        return "<img src=\""+ url + "\" alt=\"Italian Trulli\"><br>";
    }

    private String parseHeader(String title){
        return "<header><title>" + title + "</title></header>\n";
    }

}
