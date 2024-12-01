package org.jtp.domain;

public class Student {
    private int id_student;
    private String name;
    private String last_name;
    private String phonenumber;
    private String email;

    public Student() {
    }

    public Student(int id_student) {
        this.id_student = id_student;
    }

    public Student(String name, String last_name, String phonenumber, String email) {
        this.name = name;
        this.last_name = last_name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
