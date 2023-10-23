package com.spotify.oauth2.api.assertion;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.pojo.Error;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GlobalAssertion {

    @Step
    public static void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step
    public static void assertError(Error responseError, StatusCode statusCode) {
        assertThat(responseError.getError().getStatus(), equalTo(statusCode.code));
        assertThat(responseError.getError().getMessage(), equalTo(statusCode.message));
    }
}
