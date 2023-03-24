package com.student;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentLeaveApplicationTests {
	@Test
    @Order(1)
    public void testAddLeave() {
    	String jsonbody="{\"description\":\"Sick leave\",\"fromdate\":\"2022/09/12\",\"todate\":\"2022/09/04\",\"student_email\":\"maggi@gmail.com\",\"teacher_email\":\"veena@gmail.com\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8089/api/addleave")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
	
	@Test
    @Order(2)
    public void testUpdateFees() {
    	String jsonbody="{\"student_email\":\"maggi@gmail.com\",\"fees\":\"false\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .put("http://localhost:8089/api/payfees")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
	@Test
    @Order(4)
    public void testStudentFees() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8089/api/Studentfees/maggi@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
	 
}
