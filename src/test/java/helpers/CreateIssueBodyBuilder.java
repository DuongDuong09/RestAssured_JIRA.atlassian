package helpers;

import constants.RequestCapability;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateIssueBodyBuilder implements RequestCapability {
    public JSONObject getJSONContent() {
//        String bodyStr = "{\n" +
//                "  \"fields\": {\n" +
//                "    \"summary\": \"summary from api\",\n" +
//                "    \"project\": {\n" +
//                "      \"key\": \"DUONGNGUYE\"\n" +
//                "    },\n" +
//                "    \"issuetype\": {\n" +
//                "      \"id\": \"10001\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";
        Map<String, Object> project = new HashMap<String, Object>();
        project.put("key", projectKey);

        Map<String, Object> issueType = new HashMap<String, Object>();
        issueType.put("id", "10001");

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("summary", RandomData.RandomDataInput());
        payload.put("project", project);
        payload.put("issuetype", issueType);

        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put("fields", payload);
        JSONObject requestPayload = new JSONObject(fields);
        return requestPayload;
    }
}
