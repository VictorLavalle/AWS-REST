package com.aws.rest.entity;

public class Student {

    private Long id;
    private String registrationID;
    private String name;
    private String lastName;
    private int average;


    /**
     * Constructors
     */
    public Student() {
    }

    public Student(String registrationID, String name, String lastName, int average) {
        this.registrationID = registrationID;
        this.name = name;
        this.lastName = lastName;
        this.average = average;
    }

    public Student(Long id, String registrationID, String name, String lastName, int average) {
        this.id = id;
        this.registrationID = registrationID;
        this.name = name;
        this.lastName = lastName;
        this.average = average;
    }

    /**
     * id Getter & Setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * registrationID Getter & Setter
     */
    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    /**
     * Student's name Getter & Setter
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Student's name Getter & Setter
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Student's average Getter & Setter
     */
    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    /**
     * Student's data
     */
    @Override
    public String toString() {
        return "Student{" +
                "id:" + id +
                ", registrationID:" + registrationID +
                ", name:" + name + '\'' +
                ", lastName:" + lastName + '\'' +
                ", average:" + average +
                '}'+ "\n";
    }
}
