package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requests {
  
  /** 
   * This method performs a GET request to a specified endpoint
   * 
   * @param endpoint the endpoint to perform the GET request
   * @return Response the response object indicating the result of the request
   */
  public static Response getRequest(String endpoint) {
    return RestAssured.given().get(endpoint);
  }

  /** 
   * This method performs a POST request to a specified endpoint with a specified body
   * 
   * @param endpoint the endpoint to perform the POST request
   * @param body the body object of the POST request (e.g POJO)
   * @return Response the response object indicating the result of the request
   */
  public static Response postRequest(String endpoint, Object body) {
    return RestAssured.given().contentType("application/json").body(body).when().post(endpoint);
  }
  
  /** 
   * This method performs a PUT request to a specified endpoint with a specified body
   * 
   * @param endpoint the endpoint to perform the PUT request
   * @param body the body object of the PUT request (e.g POJO)
   * @return Response the response object indicating the result of the request
   */
  public static Response putRequest(String endpoint, Object body) {
    return RestAssured.given().contentType("application/json").body(body).when().put(endpoint);
  }

  
  /** 
   * This method performs a DELETE request to a specified endpoint
   * 
   * @param endpoint the endpoint to perform the DEKETE request
   * @return Response the response object indicating the result of the request
   */
  public static Response deleteRequest(String endpoint) {
    return RestAssured.given().delete(endpoint);
  }
}
