package com.spotify.oauth2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static com.spotify.oauth2.api.SpecBuilder.*;
import static com.spotify.oauth2.api.applicationApi.Routes.API;
import static com.spotify.oauth2.api.applicationApi.Routes.TOKEN;
import static io.restassured.RestAssured.given;

public class RestResource {


    public static Response post(String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
               body(requestPlaylist).
                auth().oauth2(token).
        when().post(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }


    public static Response get(String path, String token){
        return  given(getRequestSpec()).
                auth().oauth2(token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, Object requestPlaylist){
       return given(getRequestSpec()).
                body(requestPlaylist).
               auth().oauth2(token).
                when().put(path).
                then().spec(getResponseSpec()).
               extract().
               response();
    }

    public static Response postAccount(HashMap<String, String> formParams){

        return given(getAccountRequestSpec()).
                formParams(formParams).
                post().
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
