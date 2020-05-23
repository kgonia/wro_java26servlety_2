package org.sda.java26.model;

public class Student {

    private String name;

    private String surname;

    private Integer yearOfStudy;

    public Student(String name, String surname, Integer yearOfStudy) {
        this.name = name;
        this.surname = surname;
        this.yearOfStudy = yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
