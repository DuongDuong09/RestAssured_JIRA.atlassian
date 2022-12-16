package testcase;

import constants.RequestCapability;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProject implements RequestCapability {
    @Test
    public void Get_project_details() {
        String path = "/rest/api/3/project/";
        given().baseUri(baseUri).basePath(path.concat(projectKey)).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                get().
                then().
                assertThat().
                statusCode(200).
                log().body().extract().response();
    }
}
