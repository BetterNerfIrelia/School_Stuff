package at.fhv.ssc.mojo;

import at.fhv.ssc.hibernate.DatabaseFacade;
import at.fhv.ssc.pojo.Userentry;

import java.util.List;

public class UserBean {

    private String username;
    private String fname;
    private String lname;
    private String password;
    private String level;
    private boolean success;
    private String reasonForFailure;

    public UserBean(String username, String fname, String lname, String password, String level) {

        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.level = level;
        success = false;
        reasonForFailure = "";

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public void saveUser() {
        DatabaseFacade facade = new DatabaseFacade();
        Userentry user = facade.loadUserentry(username);
        if(user == null){

            facade.safeUserEntry(username, fname,lname,password,level);
            success = true;

        }else{
            success = false;
        }
    }


}




