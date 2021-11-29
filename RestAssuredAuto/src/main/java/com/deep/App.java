package com.deep;

import au.com.anthonybruno.Gen;
import au.com.anthonybruno.generator.defaults.IntGenerator;
import com.github.javafaker.Faker;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ){

        RequestSpecification reqSpec= new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .build();


        ResponseSpecification resSpec=new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();


        //Adding Value to Pojo

        BodyPojo bp= new BodyPojo();

        bp.setName("Deepak");
        bp.setJob("Tester");


        ResponsePojo response=given()
                .spec(reqSpec)
                .body(bp)
                .expect().defaultParser(Parser.JSON)
                .when()
                .post("api/users")
                .then()
                .spec(resSpec)
                .extract()
                .as(ResponsePojo.class);





        System.out.println(response.getId());
        System.out.println(response.getName());



        /**
         * Validating the Response and Printing it.
         */

//        System.out.println(response.getStatusCode());
//
//        System.out.println(response.asString());
//
//
//        JsonPath js = new JsonPath(response.asString());
//        System.out.println(js.getString("id"));



    }
}
