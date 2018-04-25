package at.fhv.ssc.mojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {

    private String time;
    private String site;

    public Visit(String site) {
        time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.site = site;
    }

    public String getTime() {
        return time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}


