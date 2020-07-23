import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import java.util.Date;

public class JwtTest {

    @Test
    public void testCreateJwt(){
        JwtBuilder builder = Jwts.builder();
         builder.setId("888")
                .setSubject("龍門")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast"); // //设置签名 使用HS256算法，并设置SecretKey(字符串)
        String token = builder.compact();
        System.out.println(token);
        System.out.println(Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody());
    }


}
