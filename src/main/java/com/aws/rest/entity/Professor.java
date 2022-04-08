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
    private int numeroEmpleado;

    @NotEmpty(message = "Field must not be empty")
    private String nombres;

    @NotEmpty(message = "Field must not be empty")
    private String apellidos;

    @NotNull (message = "Field must not be empty")
    @PositiveOrZero (message = "Class hours cannot be negative")
    private int horasClase;

    /**
     * Constructors
     */
    public Professor() {
    }

    public Professor(int numeroEmpleado, String nombres, String apellidos, int horasClase) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public Professor(Long id, int numeroEmpleado, String nombres, String apellidos, int horasClase) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
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
    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    /**
     * Professor's name Getter & Setter
     */
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Professor's last name Getter & Setter
     */
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Professor's class hours Getter & Setter
     */
    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id:" + id +
                ", numeroEmpleado:" + numeroEmpleado +
                ", nombres:'" + nombres + '\'' +
                ", apellidos:'" + apellidos + '\'' +
                ", horasClase:'" + horasClase + '\'' +
                '}';
    }
}
