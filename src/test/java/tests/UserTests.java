package tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;
import requests.Requests;
import utils.UtilsMethods;

public class UserTests {

  static {
    System.setProperty("log4j.configurationFile", "log4j2.properties");
  }

  List<User> usersList;

  private static final Logger LOGGER = LogManager.getLogger(UserTests.class);

  @BeforeClass
  public void beforeClass() {
    RestAssured.baseURI = "https://65442d705a0b4b04436c1cb4.mockapi.io";
  }


  @Test
  public void testEmptyUserData() {
    Response response;

    response = Requests.getRequest("/users");

    List<User> usersList = response.jsonPath().getList("", User.class);

    LOGGER.info("Users List at start: " + usersList);

    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(usersList.size(), 0);
  }

  @Test(dependsOnMethods = "testEmptyUserData")
  public void testCreateRandomUsers() {
    Response response;

    for (int i = 0; i < 10; i++) {
      User user = new User();

      user.setFirstName("User " + (i + 1));
      user.setLastName("Lastname " + (i + 1));
      user.setEmail("test" + (i + 1) + "@gmail.com");
      user.setPassword("test123");
      user.setAccountNumber("10" + (i + 1));    
      
      response = Requests.postRequest("/users", user);
      Assert.assertEquals(response.getStatusCode(), 201);
    }
  }

  @Test(dependsOnMethods = "testCreateRandomUsers")
  public void testNoDuplicateEmails() {
    Response response;

    response = Requests.getRequest("/users");

    usersList = response.jsonPath().getList("", User.class); 
    
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertFalse(usersList.isEmpty());

    LOGGER.info("Users List after posting 10 random: " + usersList);

    List<String> emailsList = new ArrayList<>();
    for (User user : usersList) {
      emailsList.add(user.getEmail());
    }

    Assert.assertTrue(UtilsMethods.hasNoDuplicates(emailsList));
  }

  @Test(dependsOnMethods = "testNoDuplicateEmails")
  public void testUpdateExistingAccountNumber() {
    Response response;

    String userId = usersList.get(0).getId();

    User updatedUser = new User();
    updatedUser.setAccountNumber("456456");

    response = Requests.putRequest("/users/" + userId, updatedUser);

    Assert.assertEquals(response.getStatusCode(), 200);
  }

  @Test(dependsOnMethods = "testUpdateExistingAccountNumber")
  public void testCleanupDatabase() {
    Response response;
    for (User user : usersList) {
      response = Requests.deleteRequest("/users/" + user.getId());
      Assert.assertEquals(response.getStatusCode(), 200);
    }

    response = Requests.getRequest("/users");

    usersList = response.jsonPath().getList("", User.class);

    Assert.assertTrue(usersList.isEmpty());
  }
}
