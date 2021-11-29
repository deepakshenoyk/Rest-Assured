package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class goRestSteps {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response response;

    @Given("The Go Rest API for POST call")
    @Given("The Go Rest API for GET call")
    public void the_go_rest_api_for_get_call() {
        reqSpec= new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1/users/")
                .addHeader("Accept","application/json")
                .addHeader("Authorization","Bearer 97931aebea7b71f2f7cb50da8274f466d263038a48e76e0421d270e07aca3d74")
                .setContentType("application/json").
                        build();

        resSpec=new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }
    @When("the API is triggered for {int}")
    public void the_api_is_triggered_for(Integer userID) {


       response=given().spec(reqSpec)
               .when()
               .get(userID.toString())
               .then()
               .spec(resSpec)
               .extract()
               .response();
    }

    @When("the API is triggered with {string} and {string} and {string} and {string} as body")
    public void the_api_is_triggered_with_and_and_and_as_body(String name, String gender, String emailID, String activeStatus) {

        String bodyDetails="{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+emailID+"\", \"status\":\""+activeStatus+"\"}";

        response=given().spec(reqSpec)
                .body(bodyDetails)
                .when()
                .post()
                .then()
                .spec(resSpec)
                .extract()
                .response();
    }

    @Then("Validate the Response code {int}")
    public void validate_the_response_code(Integer statusCode) {
        Assert.assertTrue("Status Code Error",statusCode==response.statusCode());

    }
    @And("Validate the response contains the {string} and {string} and {string} and {string}")
    public void validate_the_response_contains_the_and_and_and(String name, String emailID, String gender, String activeStatus) {

        JsonPath js = new JsonPath(response.asString());
        Assert.assertEquals(js.getString("data.name"), name);
        Assert.assertEquals(js.getString("data.email"), emailID);
        Assert.assertEquals(js.getString("data.gender"), gender);
        Assert.assertEquals(js.getString("data.status"), activeStatus);
    }
}
