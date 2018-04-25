package at.fhv.ssc.mojo;

import at.fhv.ssc.hibernate.DatabaseFacade;
import at.fhv.ssc.pojo.Userentry;

public class LoginBean {

    private String username;
    private String passwort;
    private boolean success;
    private String reasonForFailure;

public LoginBean(){

}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReasonForFailure() {
        return reasonForFailure;
    }

    public void setReasonForFailure(String reasonForFailure) {
        this.reasonForFailure = reasonForFailure;
    }

    public void checkLogIn(String username, String passwort){

    this.username = username;
    this.passwort = passwort;

    DatabaseFacade facade = new DatabaseFacade();
    Userentry entry = facade.loadUserentry(username);

    if(entry != null){
        if(passwort.equals(entry.getPassword())){
            success = true;

        }else{
            success = false;

        }

    }else{
        success = false;

    }







}



}
