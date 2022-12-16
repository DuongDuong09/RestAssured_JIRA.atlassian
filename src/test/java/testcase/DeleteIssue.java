package testcase;

import constants.RequestCapability;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteIssue implements RequestCapability{
    @Test
    public void Delete_Issue(){
        //moi lan run test case nay thi phai thay doi issueId do lan chay truoc xoa mat roi
        String issueIdOrKey="DUONGNGUYE-42";
        String pathComment = "/rest/api/3/issue/{issueIdOrKey}";
        given().baseUri(baseUri).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                pathParam("issueIdOrKey",issueIdOrKey)
                .delete(pathComment).
                then().
                assertThat().
                statusCode(204).
                log().body().extract().response();

    }
}
