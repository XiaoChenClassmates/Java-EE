package cn.chenshujun.service;

import cn.chenshujun.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * JWT实现类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/22
 */
@Setter
@Service
@ConfigurationProperties("jwt")
public class JwtService {
    private String iss;                     // 发行人
    private String secretKey;               // 密钥
    private Long expirationTime;         // 过期时间

    /**
     * 生成token
     */
    public String sign(User user) {
        Date expireAt = new Date(System.currentTimeMillis() + expirationTime * 1000);
        return JWT.create()
                .withIssuer(iss)
                //存放数据
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("age", user.getAge())
                .withClaim("rid", user.getRid())
                .withClaim("rolename", user.getRolename())
                //过期时间
                .withExpiresAt(expireAt)
                .sign(Algorithm.HMAC256(secretKey));
    }


    /**
     * token验证
     */
    public DecodedJWT verify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretKey)).withIssuer(iss).build();
        return jwtVerifier.verify(token);
    }

}
