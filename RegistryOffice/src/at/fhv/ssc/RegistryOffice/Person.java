package at.fhv.ssc.RegistryOffice;

/**
 * Created by sebastian on 30.03.2017.
 */
public class Person {
    private String _name;
    private String _familyname;
    private String _gender;
    private boolean _married;
    private String _partner;

    public Person (String name, String familyname, String gender, boolean married, String partner){
        _name = name;
        _familyname = familyname;
        _gender = gender;
        _married = false;
        _partner = partner;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getFamilyname() {
        return _familyname;
    }

    public void setFamilyname(String familyname) {
        _familyname = familyname;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public boolean isMarried() {
        return _married;
    }

    public void setMarried(boolean married) {
        _married = married;
    }

    public String getPartner() {
        return _partner;
    }

    public void setPartner(String partner) {
        _partner = partner;
    }
}








