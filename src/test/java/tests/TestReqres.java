package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.GET;
import static utils.Steps.isStatusCodeValid;

public class TestReqres {

    @BeforeSuite
    public void setUp(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUsers(){

        String url = "/users?page=2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);

    }

    @Test
    public void testSingleUser(){

        String url = "/users/2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);
    }
}
