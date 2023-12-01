package cn.chenshujun.service;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;
import java.util.Objects;

/**
 * JWT拦截器
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/22
 */
@Service
@RequiredArgsConstructor
public class TokenInterceptorService implements HandlerInterceptor {

    private final JwtService jwtService;
    private final HashOperations<String, String, Object> hashOperations;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("token");
        if (token != null) {
            DecodedJWT result = jwtService.verify(token);
            int id = result.getClaim("id").asInt();
            if (!Objects.equals(hashOperations.get("user", String.valueOf(id)), token))
                throw new TokenExpiredException("token过期", Instant.EPOCH);
            request.setAttribute("id", id);
            return true;
        }
        return false;
    }
}
