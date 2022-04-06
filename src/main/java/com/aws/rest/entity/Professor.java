package com.aws.rest.entity;

public class Professor {

    private Long id;
    private Long employeeNumber;
    private String name;
    private String lastName;
    private Float classHours;

    /**
     * Constructors
     */
    public Professor() {
    }

    public Professor(Long employeeNumber, String name, String lastName, Float classHours) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.lastName = lastName;
        this.classHours = classHours;
    }

    public Professor(Long id, Long employeeNumber, String name, String lastName, Float classHours) {
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
    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
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
    public Float getClassHours() {
        return classHours;
    }

    public void setClassHours(Float classHours) {
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
