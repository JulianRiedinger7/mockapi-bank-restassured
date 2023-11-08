# Bank API Automation Exercise

This project demonstrates best practices for testing a bank API using RestAssured with Java.

## Specifications

The following scenarios are covered:

- Test 1: Verify that the endpoint is empty.
- Test 2: Initialize the POJO with random user data and avoid duplicate email accounts.
- Test 3: Make a GET request to retrieve users and assert there are no duplicate email accounts.
- Test 4: Update an existing AccountNumber.
- Test 5: Verify the correct deposit of money.
- Test 6: Verify the correct withdrawal of money.

## Setup and Dependencies

To run this project, you need the following dependencies:

- Java
- TestNG
- RestAssured
- Mock API project

## Running the Tests

1. Clone this repository to your local machine.
2. Set up the required dependencies (Java, TestNG, RestAssured).
3. Run the tests using your preferred IDE or command line: ``` mvn test ```
4. Review the test results in the test framework's output or logs.
