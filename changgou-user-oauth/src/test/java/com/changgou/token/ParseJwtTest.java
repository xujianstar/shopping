package com.changgou.token;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

/*****
 * @Author: www.itheima
 * @Date: 2019/7/7 13:48
 * @Description: com.changgou.token
 *  使用公钥解密令牌数据
 ****/
public class ParseJwtTest {

    /***
     * 校验令牌
     */
    @Test
    public void testParseToken(){
        //令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJpdGhlaW1hIiwiaWQiOiIxIn0.CvvxPTAoVhS8V-7l3l87l92xiKLEqfeBd5_VT0uudAOzzUK0ghHSAN7M7LlCyIRS92m5cgDC1SN12ZrFlIwWw8zhyWWsPIDpfZdVL-YPoWQdgFntAMvPYncHYRXHpIY-qeTxLUhndiiA1ePsCigtkDqD1p3mxDe7REzS88TBT9Ny7CQ0WOTWZllQYkZFcPd8b7awg3bfKXJLltvt9bV1Ij21nmPzrFyeGA63GNPfyX88IuMOcZSmbT2J1ECzu8iU-pJgBATmD1V9zW6hXl86iwIOGkAf2QSWvcgrBlZEgzsn4m7TdBUisy9iDHoUES7MC_FqFI2SU4rhyAuqbhDlzg";

        //公钥
        String publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAohGhilEuTPDZsXhjLKIP\n" +
                "ytdiuO+HBBBWRyt7nrkDgMYKPdgeKNhZZCerDjcpiIdhd4gqhBHONAJMHOqkl6Rn\n" +
                "0NK4Kw4B9bt2IorJf6SAp+08K+8Q5M9K5Sz++I6fmzsryJuOmwVczLlFCm+CZJGn\n" +
                "I+ypr9NvY/m4EqO+onMMAPU/5eYhkp2NUwsnVeZdhUjPwMX1LPLy2228JLkxgqzV\n" +
                "gKySK3La6S802OoSAYQTeValhDf6BwyV39SPt6cVpddd+OhJ3x69Gxjl2P0pK+3k\n" +
                "mg/BecSvvdB2lQ7qQ5HwRj8wN84e5UA9anVf1sToCM53myyJRdnrdmUMdEhucrJl\n" +
                "GwIDAQAB\n" +
                "-----END PUBLIC KEY-----";

        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容 载荷
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
