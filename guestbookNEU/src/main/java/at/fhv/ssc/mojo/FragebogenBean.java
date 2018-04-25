package at.fhv.ssc.mojo;


import at.fhv.ssc.FormDelegate;
import at.fhv.ssc.hibernate.DatabaseFacade;
import at.fhv.ssc.pojo.Fragebogen;
import at.fhv.ssc.pojo.Userentry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped

public class FragebogenBean {

    private FormDelegate formDelegate = new FormDelegate();


    public FragebogenBean() {
    }


    private String userid;
    private String course;
    private String coursecontent;
    private ArrayList<String> platform;
    private String comment;
    private boolean success;


    public FragebogenBean(String userid, String course, String coursecontent, ArrayList<String> platform, String comment) {

        this.userid = userid;
        this.course = course;
        this.coursecontent = coursecontent;
        this.platform = platform;
        this.comment = comment;
        success = false;

    }

    public String saveFragenbogen() {
        DatabaseFacade facade = new DatabaseFacade();
        Fragebogen bogen = facade.loadFragebogen(userid);
        if (bogen == null) {

            facade.safeFragebogen(userid, course, coursecontent, platform.toString(), comment);
            success = true;

        } else {
            success = false;
        }
    return "fragebogenSuccess";
    }

    public FormDelegate getFormDelegate() {
        return formDelegate;
    }

    public void setFormDelegate(FormDelegate formDelegate) {
        this.formDelegate = formDelegate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent;
    }

    public ArrayList<String> getPlatform() {
        return platform;
    }

    public void setPlatform(ArrayList<String> platform) {
        this.platform = platform;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}


