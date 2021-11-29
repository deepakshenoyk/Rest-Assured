package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    String baseuri;
    String body;

    @Given("the base url is {string}")
    public void the_base_url_is(String baseUrl) {

        baseuri=baseUrl;


    }
    @Given("the body is \"\\{\"name\":\"morpheus\",\"job\":\"leader\"}\"")
    public void the_body_is() {

    }
    @When("the {string} request {string}")
    public void the_request(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify that the status is {string}")
    public void verify_that_the_status_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response contains {string}")
    public void the_response_contains(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
