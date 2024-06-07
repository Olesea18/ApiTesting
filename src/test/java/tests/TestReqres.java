package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.*;

public class TestReqres {

    @BeforeSuite
    public void setUp(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUsers(){

        System.out.println("test list");
        String url = "/users?page=2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);

    }

    @Test
    public void testSingleUser(){
        System.out.println("test get");
        String url = "/users/2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);

        isBodyContainsValue(response, "data.first_name", "Janet");
    }

    @Test
    public void testCreate(){
        System.out.println("test post");
        String url = "/users";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";


        Response response = POST(body, url);

        isStatusCodeValid(response, 201);

        isBodyContains(response, "id");

    }

    @Test
    public void testUpdate(){
        System.out.println("test put");
        String url = "/users/13";

        String body = "{\n" +
                "    \"name\": \"neo\",\n" +
                "    \"job\": \"developer\"\n" +
                "}";


        Response response = PUT(body, url);

        isStatusCodeValid(response, 200);
    }

    @Test
    public void testPartialUpdate(){
        System.out.println("test patch");
        String url = "/users/9";

        String body = "{\n" +
                "    \"job\": \"the chosen one\"\n" +
                "}";


        Response response = PATCH(body, url);

        isStatusCodeValid(response, 200);

    }
    @Test
    public void testDELETE(){
        System.out.println("test delete");
        String url = "/users/2";


        Response response = DELETE(url);

        isStatusCodeValid(response, 204);


    }
}



