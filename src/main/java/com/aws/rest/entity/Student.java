package com.aws.rest.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Student {

    @NotNull(message = "Field must not be empty")
    @PositiveOrZero(message = "ID cannot be negative")
    private long id;

    @NotEmpty(message = "Field must not be empty")
    private String registrationID;

    @NotEmpty(message = "Field must not be empty")
    private String name;

    @NotEmpty(message = "Field must not be empty")
    private String lastName;

    @NotNull (message = "Field must not be empty")
    @PositiveOrZero (message = "Average cannot be negative")
    private double average;


    /**
     * Constructors
     */
    public Student() {}

    public Student(String registrationID, String name, String lastName, double average) {
        this.registrationID = registrationID;
        this.name = name;
        this.lastName = lastName;
        this.average = average;
    }

    public Student(long id, String registrationID, String name, String lastName, double average) {
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

    public void setId(long id) {
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
    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
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
