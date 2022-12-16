package constants;

import helpers.AuthenticationHandler;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface RequestCapability {

     Header defaultHeader=new Header("Content-type","application/json; charset-UTF-8");
    Header acceptJSONHeader=new Header("Accept"," application/json");
    String baseUri = "https://duonguyen0811.atlassian.net";
    String projectKey = "DUONGNGUYE";
    String token = "Rrbvf4jfZ7VKIXVlTofP69C7";
    String email = "duonguyen0811@gmail.com";
    String encodedCredStr = AuthenticationHandler.encodedCredStr(email,token);
    static Header getAuthenticatedHeader(String encodesCredStr){
        if(encodesCredStr==null){
            throw new IllegalArgumentException(" encodedCredStr can't be null");
        }
        return new Header("Authorization","Basic "+encodesCredStr);
    }

}