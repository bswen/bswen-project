package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * Created by zz on 2017/3/15.
 */
public class TestJwtOfAuth0 {
    private static final String THE_SECRET = "secret0";
    public static void main(String[] args) {
        try {
            //create token
            Algorithm algorithm = Algorithm.HMAC256(THE_SECRET);
            String token = JWT.create()
                    .withIssuer("bswen")
                    .withClaim("key1","value1")
                    .withClaim("key2","value2")
                    .withIssuedAt(new Date())
                    .sign(algorithm);
            System.out.println("token="+token);

            //Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("bswen")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("alg="+jwt.getAlgorithm());
            System.out.println("type="+jwt.getType());
            Claim claim = jwt.getHeaderClaim("owner");
            System.out.println("header claim is null:"+claim.isNull());
            System.out.println("issuer:"+jwt.getIssuer());
            System.out.println("subject:"+jwt.getSubject());
            System.out.println("expired at:"+jwt.getExpiresAt());
            System.out.println("issue at:"+jwt.getIssuedAt());
            System.out.println("jwt id="+jwt.getId());
            Map<String, Claim> claims = jwt.getClaims();
            System.out.println("claims size:"+claims.size());
            System.out.println("--------real payloads-------");
            claims.forEach((k,v)-> System.out.println(k+"-->"+v.asString()));
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
            exception.printStackTrace();
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
    }
}
