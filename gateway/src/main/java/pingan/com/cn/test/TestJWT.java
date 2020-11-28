package pingan.com.cn.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TestJWT {

    public static void main(String[] args) {
/*        JwtBuilder builder= Jwts.builder()
                .setId("888")             //设置唯一编号
                .setSubject("小白")       //设置主题  可以是JSON数据
                .setIssuedAt(new Date())  //设置签发日期
                .signWith(SignatureAlgorithm.HS256,"itcast");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //构建 并返回一个字符串
        System.out.println( builder.compact() );*/

         String pwd = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1OTcxMjY1OTJ9.XtH9X_JZkFZ_bbe6iMVyhBA6hHdv1qjtT2Wz2x4sWXY" ;
        Claims claims = Jwts.parser().
                setSigningKey("itcast").
                parseClaimsJws(pwd).
                getBody();
        System.out.println(claims);
    }
}
