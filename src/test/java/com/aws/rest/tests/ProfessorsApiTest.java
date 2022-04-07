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

public class ProfessorsApiTest {

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
                .get("/professorsinvalidpath")
                .then()
                .statusCode(404);
    }

    @Test
    public void testUnsuportedMethod() {
        given().spec(SPEC)
                .delete("/professors")
                .then()
                .statusCode(405);
    }

    @Test
    public void testGetProfesores() {
        given().spec(SPEC)
                .get("/professors")
                .then()
                .statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void testPostProfesor() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);
    }

    @Test
    public void testGetProfesorById() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(profesor.get("name")))
                .body("classHours", equalTo(profesor.get("classHours")));
    }

    @Test
    public void testPutProfesor() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(profesor.get("name")))
                .body("classHours", equalTo(profesor.get("classHours")));

        profesor.put("name", "Nuevo Profesor");
        profesor.put("classHours", Constants.getRandomHoras());

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .put("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(profesor.get("name")))
                .body("classHours", equalTo(profesor.get("classHours")));

    }

    @Test
    public void testPutProfesorWithWrongFields() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .body("name", equalTo(profesor.get("name")))
                .body("classHours", equalTo(profesor.get("classHours")));

        profesor.put("name", null);
        profesor.put("classHours", -1.26d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .put("/professors/" + profesor.get("id"))
                .then()
                .statusCode(400).contentType(ContentType.JSON);

    }

    @Test
    public void testPostProfesorWithWrongFields() {

        Map<String, Object> profesor = new HashMap<>();
        profesor.put("id", 0);
        profesor.put("name", "");
        profesor.put("lastName", null);
        profesor.put("employeeNumber", -3688);
        profesor.put("classHours", -1.26d);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(400).contentType(ContentType.JSON);
    }

    @Test
    public void testDeleteProfesor() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        given().spec(SPEC)
                .delete("/professors/" + profesor.get("id"))
                .then()
                .statusCode(200);

        given().spec(SPEC)
                .get("/professors/" + profesor.get("id"))
                .then()
                .statusCode(404);

    }

    @Test
    public void testDeleteWrongProfesor() {

        Map<String, Object> profesor = getProfessor();

        given().spec(SPEC)
                .contentType(ContentType.JSON)
                .body(profesor)
                .post("/professors")
                .then()
                .statusCode(201).contentType(ContentType.JSON);

        given().spec(SPEC)
                .delete("/professors/" + Constants.getRandomId())
                .then()
                .statusCode(404);
    }

    private Map<String, Object> getProfessor() {
        Map<String, Object> profesor = new HashMap<>();
        profesor.put("id", Constants.getRandomId());
        profesor.put("name", "Profesor");
        profesor.put("lastName", "Rodriguez");
        profesor.put("employeeNumber", Constants.getRandomId());
        profesor.put("classHours", Constants.getRandomHoras());
        return profesor;
    }

}
