package testcase;

import constants.RequestCapability;
import helpers.CreateIssueBodyBuilder;
import helpers.GetVariable;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateIssue extends GetVariable implements RequestCapability {
    GetVariable variable=new GetVariable();
    @Test
    public void Create_Issue() {
        System.out.println("CREATE ISSUE");
        String pathComment = "/rest/api/3/issue";
        Response response = given().baseUri(baseUri).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                when().
                body((new CreateIssueBodyBuilder().getJSONContent()).toString()).
                post(pathComment).
                then().
                assertThat().
                statusCode(201).
                log().body().extract().response();
        String projectInfor=JsonPath.from(( response).asString()).get("key");
        variable.setVariable(projectInfor);

    }
    @Test
    public void get_issue_information(){
        System.out.println("---------------------------------------------------");
        System.out.println("GET ISSUE DETAILS");
        String pathComment = "/rest/api/3/issue/{issueIdOrKey}";
        given().baseUri(baseUri).basePath(pathComment).
                header(RequestCapability.getAuthenticatedHeader(encodedCredStr)).
                header(acceptJSONHeader).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                pathParam("issueIdOrKey","DUONGNGUYE-44").
                when().
                get().
                then().
                assertThat().
                statusCode(200).
                log().body().extract().response();
    }
    }
