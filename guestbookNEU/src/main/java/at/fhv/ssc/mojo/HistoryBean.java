package at.fhv.ssc.mojo;

import java.util.ArrayList;
import java.util.List;

public class HistoryBean {

    private List<Visit> visits;


    public HistoryBean(){
        visits = new ArrayList<Visit>();
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void getSite(){

    }

    public void addVisit(String site){
        Visit visit = new Visit(site);
        visits.add(visit);
    }



}
