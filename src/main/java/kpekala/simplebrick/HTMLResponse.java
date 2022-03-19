package kpekala.simplebrick;

import kpekala.simplebrick.model.SetModel;

public class HTMLResponse {
    private SetModel setModel;

    public HTMLResponse(SetModel setModel){
        this.setModel = setModel;
    }

    public String parse(){
        return String.format("<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>%s</body>\n" + "</html>", parseBody());
    }

    public String parseBody(){
        return String.format("<img src=\"%s\" alt=\"Italian Trulli\">", setModel.getImage().getThumbnailURL());
    }
}
