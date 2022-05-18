package com.aws.rest.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiante")
public class Student {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "Field must not be empty")
    @PositiveOrZero(message = "ID cannot be negative")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
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

    @NotNull (message = "Missing value")
    private String fotoPerfilUrl;


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
