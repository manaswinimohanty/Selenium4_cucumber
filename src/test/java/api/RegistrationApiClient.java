package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import factories.UserFactories;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import pojo.Users;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

// In a separate package, e.g., src/test/java/api/client
public class RegistrationApiClient {


        private String registeredEmail;
        private String registeredPassword;
        private String baseUrl = "https://automationexercise.com/api"; // **IMPORTANT: Replace with your actual API base URL**
    private Users users;
        public void registerNewUser() {
            System.out.println("inside registerNewUser method====");
            // Generate dynamic username/password for uniqueness
            registeredEmail = "testuser_" + System.currentTimeMillis() + "@example.com";
            registeredPassword = "Password" + "1!";
            users = UserFactories.createDefault();
            /*Map<String, String> registrationPayload = new HashMap<>();
            registrationPayload.put("name", users.getUserName());
            registrationPayload.put("password", users.getPassword());
            registrationPayload.put("email", users.getEmail());*/


            try {
                RestAssured.registerParser("text/html", Parser.JSON);
                Response response = RestAssured.given().log().body().contentType("multipart/form-data")
                        .accept(ContentType.JSON)

                        .multiPart("name",users.getUserName())
                        .multiPart("email",registeredEmail)
                        .multiPart("password",registeredPassword)
                        .multiPart("title","Mr")
                        .multiPart("birth_date","1")
                        .multiPart("birth_month","1")
                        .multiPart("birth_year",users.getYear())
                        .multiPart("firstname",users.getFirstName())
                        .multiPart("lastname",users.getLastName())
                        .multiPart("company",users.getCompany())
                        .multiPart("address1",users.getAddress())
                        .multiPart("address2",users.getSecondaryAddress())
                        .multiPart("country",users.getCountry())
                        .multiPart("zipcode",users.getZipcode())
                        .multiPart("state",users.getState())
                        .multiPart("city",users.getCity())
                        .multiPart("mobile_number",users.getMobileNo())
                        .post(baseUrl + "/createAccount");
                // **IMPORTANT: Replace with your actual registration endpoint**

                // Assertions for API response
                System.out.println("Registration API Response: " + response.getBody().asString());
                response.then().log().all().statusCode(200);
                response.then().body("responseCode",equalTo(201));
                response.then().body("message",equalTo("User created!"));


                // You might parse the response body if the API returns user details
                // For example, if the API returns a user ID or a confirmation message
                // String responseBody = response.asString();
                // ObjectMapper mapper = new ObjectMapper();
                // Map<String, Object> responseMap = mapper.readValue(responseBody, Map.class);
                // System.out.println("Registered User ID: " + responseMap.get("userId"));

                System.out.println("User registered successfully via API: " + registeredEmail);

            } catch (Exception e) {
                System.err.println("Error during API registration: " + e.getMessage());
                throw new RuntimeException("Failed to register user via API", e);
            }

        }

        public String getRegisteredEmail() {
            return registeredEmail;
        }

        public String getRegisteredPassword() {
            return registeredPassword;
        }
    }


