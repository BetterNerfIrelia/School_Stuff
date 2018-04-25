package at.fhv.ssc.arraylistserialisationionetworkingstuff;

import java.io.Serializable;

public class Test implements Serializable{

    private String _name;


    public Test(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }

    public void setName(String name){
        _name = name;
    }

    }
