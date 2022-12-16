package testcase;

import constants.RequestCapability;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Transition implements RequestCapability {
    @Test
    public void Get_transition(){
        String ISSUE_KEY="DUONGNGUYE-44";
        String getIssueTransition="/rest/api/3/issue/"+ISSUE_KEY+"/transitions";
        given().baseUri(baseUri).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                get(getIssueTransition).
                then().
                assertThat().
                statusCode(200).
                log().body().extract().response();

    }
    @Test
    public void Transition_issue(){
        String CREATE_ISSUE_KEY="DUONGNGUYE-48";
        String getIssueTransition="/rest/api/3/issue/"+CREATE_ISSUE_KEY+"/transitions";
        String transitionBody="{\n" +
                "  \"transition\": {\n" +
                "    \"id\": \"31\"\n" +
                "  }\n" +
                "}";
        given().baseUri(baseUri).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                body(transitionBody).post(getIssueTransition).then().statusCode(204).
                log().body().extract().response();
    }
}
