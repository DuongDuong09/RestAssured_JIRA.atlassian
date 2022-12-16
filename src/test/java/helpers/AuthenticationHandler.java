package helpers;

import org.apache.commons.codec.binary.Base64;

public class AuthenticationHandler {
    public static String encodedCredStr(String email,String token){
        if(email==null||token==null){
            throw new IllegalArgumentException("email or token is null");
        }
        String cres = email.concat(":").concat(token);
        byte[] encode = Base64.encodeBase64(cres.getBytes());
        return  new String(encode);
    }
}

