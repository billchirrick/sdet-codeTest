package com.happyreturns.test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;
import com.google.gson.*;
import org.json.simple.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;


import java.awt.*;
import java.io.*;

import static io.restassured.RestAssured.*;

public class BaseRestAssuredClass {

    private static final String baseuri = "https://happyreturnsqatest.free.beeceptor.com/";

    /**
     * --------======= CHALLENGE NOTES =======---------
     *
     * Per the test, please do the following:
     * 1. Write a method that performs a GET to the endpoint:  https://happyreturnsqatest.free.beeceptor.com/getProductVariants
     * 2. Map a variant object from the variants array from the GET in Step #1 to an object using any JSON library, ie: json-simple, Gson, Jackson, etc.
     * 3. Modify the "weight" field for the variant from 1.25 to 5.
     * 3. Perform a POST with the modified the object from Step #3 to the following endpoint: https://happyreturnsqatest.free.beeceptor.com/order
     *
     * Helpful hints:
     * A couple of example methods have been declared for you.
     * The postVariants() method is a good example of how you should build your REST calls.
     *
     */

    public String getVariants() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "getProductVariants");
        //        Response response = request.queryParam("id","39072856").get("order");
        SerializeToFile(response, "responseSerialized");
        return null;
    }

    public static void SerializeToFile(Object classObject, String fileName)
    {
        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(classObject);

            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String postVariants() {
        getVariants();
        Response deSerializedResponse = (Response) DeSerializeFromFileToObject("responseSerialized");
        return with()
                .baseUri(baseuri)
                .header("Content-Type", "application/json")
                .when()
                .body(deSerializedResponse)
                .request("POST", "order")
                .then()
                .extract()
                .body().jsonPath().prettyPrint();
    }

    public static Object DeSerializeFromFileToObject(String fileName)
    {
        try {
            FileInputStream fileStream = new FileInputStream(new File(fileName));
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Object deserializeObject = objectStream.readObject();

            objectStream.close();
            fileStream.close();

            return deserializeObject;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
