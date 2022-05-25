package com.aws.rest.tests;

import com.aws.rest.Constants;
import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StudentsApiTest {

    protected static String URL;
    protected static RequestSpecification SPEC;

    @BeforeAll
    public static void setUrl() {
        URL = Constants.URL;
        SPEC = new RequestSpecBuilder().setBaseUri(URL).build();
    }

    @Test
    public void testInvalidPath() {
        given().spec(SPEC)
                .get("/alumnosinvaidpath")
                .then()
                .statusCode(404);
    }

    @Test
    public void testUnsuportedMethod() {
        given().spec(SPEC)
                .delete("/alumnos")
                .then()
                .statusCode(405);
    }

    @Test
    public void testGetAlumnos() {
        given().spec(SPEC)
                .get("/alumnos")
                .then()
                .statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void testPostAlumno() {

        Map<String, Object> alumno = getAlumno();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/alumnos")
                .then()
                .statusCode(201).contentType(ContentType.JSON);
    }

    @Test
    public void testGetAlumnoById() {

        Map<String, Object> alumno = getAlumno();

        int alumnoId = crearAlumno(alumno);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("nombres", equalTo(alumno.get("nombres")))
                .body("matricula", equalTo(alumno.get("matricula")));
    }

    @Test
    public void testPutAlumno() {

        Map<String, Object> alumno = getAlumno();

        int alumnoId = crearAlumno(alumno);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("nombres", equalTo(alumno.get("nombres")))
                .body("matricula", equalTo(alumno.get("matricula")));

        alumno.put("nombres", "Nuevo Eduardo");
        alumno.put("matricula", "A" + Constants.getRandomId());

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .put("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("nombres", equalTo(alumno.get("nombres")))
                .body("matricula", equalTo(alumno.get("matricula")));

    }

    @Test
    public void testPutAlumnoWithWrongFields() {

        Map<String, Object> alumno = getAlumno();

        int alumnoId = crearAlumno(alumno);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("nombres", equalTo(alumno.get("nombres")))
                .body("matricula", equalTo(alumno.get("matricula")));

        alumno.put("nombres", null);
        alumno.put("matricula", -1.223d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .put("/alumnos/" + alumnoId)
                .then()
                .statusCode(400).contentType(ContentType.JSON);
    }

    @Test
    public void testPostAlumnoWithWrongFields() {

        Map<String, Object> alumno = new HashMap<>();
        alumno.put("id", 0);
        alumno.put("nombres", "");
        alumno.put("apellidos", null);
        alumno.put("matricula", Constants.getRandomId());
        alumno.put("promedio", -1.2d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/alumnos")
                .then()
                .statusCode(400).contentType(ContentType.JSON);
    }

    @Test
    public void testDeleteAlumno() {

        Map<String, Object> alumno = getAlumno();

        int alumnoId = crearAlumno(alumno);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .delete("/alumnos/" + alumnoId)
                .then()
                .statusCode(200);

        given().spec(SPEC)
                .get("/alumnos/" + alumnoId)
                .then()
                .statusCode(404);

    }

    @Test
    public void testDeleteWrongAlumno() {

        Map<String, Object> alumno = getAlumno();

        int alumnoId = crearAlumno(alumno);

        given().spec(SPEC)
                .delete("/alumnos/" + Constants.getRandomId())
                .then()
                .statusCode(404);

    }

    protected int crearAlumno(Map<String, Object> alumno) {
        return given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/alumnos")
                .then()
                .statusCode(201).contentType(ContentType.JSON)
                .extract()
                .path("id");
    }

    protected Map<String, Object> getAlumno() {
        Map<String, Object> alumno = new HashMap<>();
        alumno.put("nombres", "Eduardo");
        alumno.put("apellidos", "Rodriguez");
        alumno.put("matricula", "A" + Constants.getRandomId());
        alumno.put("promedio", Constants.getPromedio());
        return alumno;
    }

}
