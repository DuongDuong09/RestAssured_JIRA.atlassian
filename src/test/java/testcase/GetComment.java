package testcase;

import constants.RequestCapability;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class GetComment implements RequestCapability {
    @Test
    public void get_comment(){
        String pathComment = "/rest/api/3/issue/DUONGNGUYE-40/comment";
        given().baseUri(baseUri).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON)
                .get(pathComment).
                then().
                assertThat().
                statusCode(200).
                log().body().extract().response();

    }

}
