package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requests {
  public static Response getRequest(String endpoint) {
    return RestAssured.given().get(endpoint);
  }

  public static Response postRequest(String endpoint, Object body) {
    return RestAssured.given().contentType("application/json").body(body).when().post(endpoint);
  }

  public static Response putRequest(String endpoint, Object body) {
    return RestAssured.given().contentType("application/json").body(body).when().put(endpoint);
  }
}
