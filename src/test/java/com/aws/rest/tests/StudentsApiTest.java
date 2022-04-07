package com.aws.rest.tests;

import com.aws.rest.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StudentsApiTest {

    private static String URL;
    private static RequestSpecification SPEC;

    @BeforeAll
    public static void setUrl() {
        URL = Constants.URL;
        SPEC = new RequestSpecBuilder().setBaseUri(URL).build();
    }

    @Test
    public void testInvalidPath() {
        given().spec(SPEC)
                .get("/studentsinvalidpath")
                .then()
                .statusCode(404);
    }

    @Test
    public void testUnsuportedMethod() {
        given().spec(SPEC)
                .delete("/students")
                .then()
                .statusCode(405);
    }

    @Test
    public void testGetAlumnos() {
        given().spec(SPEC)
                .get("/students")
                .then()
                .statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void testPostAlumno() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);
    }

    @Test
    public void testGetAlumnoById() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(alumno.get("name")))
                .body("registrationID", equalTo(alumno.get("registrationID")));
    }

    @Test
    public void testPutAlumno() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(alumno.get("name")))
                .body("registrationID", equalTo(alumno.get("registrationID")));

        alumno.put("name", "Nuevo Eduardo");
        alumno.put("registrationID", "A" + Constants.getRandomId());

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .put("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(alumno.get("name")))
                .body("registrationID", equalTo(alumno.get("registrationID")));

    }

    @Test
    public void testPutAlumnoWithWrongFields() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(alumno.get("name")))
                .body("registrationID", equalTo(alumno.get("registrationID")));

        alumno.put("name", null);
        alumno.put("registrationID", -1.223d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .put("/students/" + alumno.get("id"))
                .then()
                .statusCode(400).contentType(ContentType.JSON);
    }

    @Test
    public void testPostAlumnoWithWrongFields() {

        Map<String, Object> alumno = new HashMap<>();
        alumno.put("id", 0);
        alumno.put("name", "");
        alumno.put("lastName", null);
        alumno.put("registrationID", Constants.getRandomId());
        alumno.put("promedio", -1.2d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(400).contentType(ContentType.JSON);
    }

    @Test
    public void testDeleteAlumno() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .delete("/students/" + alumno.get("id"))
                .then()
                .statusCode(200);

        given().spec(SPEC)
                .get("/students/" + alumno.get("id"))
                .then()
                .statusCode(404);

    }

    @Test
    public void testDeleteWrongAlumno() {

        Map<String, Object> alumno = getStudent();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(alumno)
                .post("/students")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .delete("/students/" + Constants.getRandomId())
                .then()
                .statusCode(404);

    }

    private Map<String, Object> getStudent() {
        Map<String, Object> alumno = new HashMap<>();
        alumno.put("id", Constants.getRandomId());
        alumno.put("name", "Eduardo");
        alumno.put("lastName", "Rodriguez");
        alumno.put("registrationID", "A" + Constants.getRandomId());
        alumno.put("promedio", Constants.getPromedio());
        return alumno;
    }

}
