package steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class APIRequestSteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I send a GET request to the (.+) URI$")
    public void i_send_a_get_request_to_the_endpoint(String URI) {
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);
    }

    @Then("^I get a (\\d+) status code$")
    public void i_get_a_list_of_users(Integer expectedStatusCode) {
        response = request
                .when()
                .get("/posts/1")
                .prettyPeek();
        json = response.then().statusCode(expectedStatusCode);
    }


    @Given("I send a DELETE request to the (.+) URI$")
    public void i_send_a_delete_request_to_the_endpoint(String URI) {
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);
    }

    @Then("^I get a (\\d+) status code confirming the deletion$")
    public void i_get_a_status_code_confirming_the_deletion(Integer expectedStatusCode) {
        response = request
                .when()
                .delete("/posts/1")
                .prettyPeek();
        json = response.then().statusCode(expectedStatusCode);
    }

    @Given("^I send a CREATE request to the (.+) URI$")
    public void i_send_a_create_request_to_the_endpoint(String URI) {
        File requestBody = new File("src/test/java/Payloads/CreateRequestBody.json");
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON)
                .body(requestBody);
    }

    @Then("^I get a (\\d+) status code which confirms the creation$")
    public void i_get_a_status_code_which_confirms_the_creation(Integer expectedStatusCode) {
        response = request
                .when()
                .post("/posts")
                .prettyPeek();
        json = response.then().statusCode(expectedStatusCode);
    }


}