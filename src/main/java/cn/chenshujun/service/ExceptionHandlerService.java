package cn.chenshujun.service;

import cn.chenshujun.util.Response;
import cn.chenshujun.util.UtilStatus;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理服务类
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/11/29
 */
@RestControllerAdvice
public class ExceptionHandlerService {

    /**
     * token过期处理
     */
    @ExceptionHandler(TokenExpiredException.class)
    public Response tokenExpiredException() {
        return new Response(UtilStatus.TOKEN_EXPIRED, null);
    }

    /**
     * token验证错误处理
     */
    @ExceptionHandler(JWTVerificationException.class)
    public Response jwtVerificationException() {
        return new Response(UtilStatus.TOKEN_VERIFY_FAIL, null);
    }
}
