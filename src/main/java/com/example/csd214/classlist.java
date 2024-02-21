package com.example.csd214;

public class classlist {
    private int Studentid;
    private String Studentname;
    private int Studentphonenumber;
    private String Teachername;

    public classlist(int Studentid, String Studentname, int Studentphonenumber, String Teachername) {
        this.Studentid = Studentid;
        this.Studentname = Studentname;
        this.Studentphonenumber = Studentphonenumber;
        this.Teachername = Teachername;
    }

    public int getStudentid() {
        return Studentid;
    }

    public void setStudentid(int studentid) {
        Studentid = studentid;
    }

    public String getStudentname() {
        return Studentname;
    }

    public void setStudentname(String studentname) {
        Studentname = studentname;
    }

    public int getStudentphonenumber() {
        return Studentphonenumber;
    }

    public void setStudentphonenumber(int studentphonenumber) {
        Studentphonenumber = studentphonenumber;
    }

    public String getTeachername() {
        return Teachername;
    }

    public void setTeachername(String teachername) {
        Teachername = teachername;
    }
}