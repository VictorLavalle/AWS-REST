package com.aws.rest.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Student {

    @NotNull(message = "Field must not be empty")
    @PositiveOrZero(message = "ID cannot be negative")
    private long id;

    @NotEmpty(message = "Field must not be empty")
    private String matricula;

    @NotEmpty(message = "Field must not be empty")
    private String nombres;

    @NotEmpty(message = "Field must not be empty")
    private String apellidos;

    @NotNull (message = "Field must not be empty")
    @PositiveOrZero (message = "Average cannot be negative")
    private double promedio;


    /**
     * Constructors
     */
    public Student() {}

    public Student(String matricula, String nombres, String apellidos, double promedio) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public Student(long id, String matricula, String nombres, String apellidos, double promedio) {
        this.id = id;
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
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
     * matricula Getter & Setter
     */
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Student's name Getter & Setter
     */
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Student's nombres Getter & Setter
     */
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Student's average Getter & Setter
     */
    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    /**
     * Student's data
     */
    @Override
    public String toString() {
        return "Student{" +
                "id:" + id +
                ", matricula:" + matricula +
                ", nombres:" + nombres + '\'' +
                ", apellidos:" + apellidos + '\'' +
                ", promedio:" + promedio +
                '}'+ "\n";
    }
}
