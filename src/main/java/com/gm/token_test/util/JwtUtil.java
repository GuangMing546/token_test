package com.gm.token_test.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    /**
     * 设置过期时间
     * 5分钟
     */
    private static final long EXPIRE_TIME = 5*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "liguangming";

    /**
     * 生成签名,5分钟后过期
     * @param userName
     * @return
     */
    public static String sign(String userName){
        //通过token秘钥和加密算法生成一个Algorithm（算法对象）
        Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
        //设置过期时间
        Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
        //设置jwt的头信息
        Map<String,Object> header=new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        //附带userName和userId生成签名
        String token= JWT.create().withHeader(header)
                            .withClaim("loginName",userName)
                            .withExpiresAt(date)
                            .sign(algorithm);
        return token;
    }

    /**
     * 验证签名
     */
    public static boolean verity(String token){
        try {
            //我们先拿到我的算法
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            //通过我们的算法拿到JWT的验证器
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt=verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
