package at.fhv.ssc.pojo;

import javax.persistence.*;

@Entity
public class Userentry {
    private String userid;
    private String fname;
    private String lname;
    private String password;
    private String level;

    @Id
    @Column(name = "USERID", nullable = false)

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "FNAME", nullable = true, length = 50)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "LNAME", nullable = true, length = 50)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 9)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "LEVEL", nullable = true, length = 50)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userentry that = (Userentry) o;

        if (userid != that.userid) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = 0;

        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
