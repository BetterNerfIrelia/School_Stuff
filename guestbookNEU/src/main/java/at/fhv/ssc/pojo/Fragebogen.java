package at.fhv.ssc.pojo;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class Fragebogen {
    private String userid;
    private String course;
    private String coursecontent;
    private String platform;
    private String comment;


    @Id
    @Column(name = "USERID", nullable = false)

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    @Basic
    @Column(name = "COURSE", nullable = true, length = 20)

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    @Basic
    @Column(name = "COURSECONTENT", nullable = true, length = 20)

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent;
    }


    @Basic
    @Column(name = "PLATFORM", nullable = true, length = 20)


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


    @Basic
    @Column(name = "COMMENT", nullable = true, length = 20)

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fragebogen that = (Fragebogen) o;

        if (userid != that.userid) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (coursecontent != null ? !coursecontent.equals(that.coursecontent) : that.coursecontent != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (coursecontent != null ? coursecontent.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
