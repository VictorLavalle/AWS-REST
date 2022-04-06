package com.aws.rest.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Professor {

    @NotNull(message = "Field must not be empty")
    @PositiveOrZero(message = "ID cannot be negative")
    private Long id;

    @NotNull(message = "Field must not be empty")
    @PositiveOrZero(message = "employeeNumber cannot be negative")
    private int employeeNumber;

    @NotEmpty(message = "Field must not be empty")
    private String name;

    @NotEmpty(message = "Field must not be empty")
    private String lastName;

    @NotNull (message = "Field must not be empty")
    @PositiveOrZero (message = "Class hours cannot be negative")
    private int classHours;

    /**
     * Constructors
     */
    public Professor() {
    }

    public Professor(int employeeNumber, String name, String lastName, int classHours) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.lastName = lastName;
        this.classHours = classHours;
    }

    public Professor(Long id, int employeeNumber, String name, String lastName, int classHours) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.lastName = lastName;
        this.classHours = classHours;
    }

    /**
     * Professor's id Getter & Setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Professor's employeeNumber Getter & Setter
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Professor's name Getter & Setter
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Professor's last name Getter & Setter
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Professor's class hours Getter & Setter
     */
    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        this.classHours = classHours;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id:" + id +
                ", employeeNumber:" + employeeNumber +
                ", name:'" + name + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", classHours:'" + classHours + '\'' +
                '}';
    }
}
