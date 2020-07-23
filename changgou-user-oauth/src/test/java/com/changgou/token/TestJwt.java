package com.changgou.token;

import org.springframework.util.Base64Utils;

public class TestJwt {
    public static void main(String[] args) {
        String pwd = "changgou:changgou";
        byte[]  decode = Base64Utils.encode(pwd.getBytes());
        System.out.println(new String(decode));
        // Y2hhbmdnb3U6Y2hhbmdnb3U=
        // Y2hhbmdnb3U6Y2hhbmdnb3U=
    }

}
