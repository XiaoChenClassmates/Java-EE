package cn.chenshujun.controller;

import cn.chenshujun.mapper.UserMapper;
import cn.chenshujun.model.User;
import cn.chenshujun.service.JwtService;
import cn.chenshujun.util.Response;
import cn.chenshujun.util.UserStatus;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * 用户控制器
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/10/10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final HashOperations<String, String, Object> hashOperations;


    /**
     * 用户登录
     *
     * @param username 用户名称
     * @param password 用户密码
     */
    @PostMapping("/login")
    public Response login(@Param("username") String username, @Param("passwrod") String password) throws NoSuchAlgorithmException {
        User user = userMapper.login(username, password);
        if (user == null) {
            return new Response(UserStatus.LOGIN_FAIL, null);
        }
        String token = jwtService.sign(user);
        hashOperations.put("user", String.valueOf(user.getId()), token);
        return new Response(UserStatus.LOGIN_SUCCESS, token);
    }

    /**
     * 用户注册
     *
     * @param username 用户名称
     * @param password 用户密码
     */
    @PostMapping("/register")
    public Response register(@Param("username") String username, @Param("passwrod") String password) throws NoSuchAlgorithmException {
        return new Response(userMapper.register(username, password), null);
    }

    /**
     * 分页查询所有用户
     *
     * @param start 分页起始id
     * @param limit 一次查询条数
     */
    @GetMapping("/queryLimitAll")
    public Response queryLimitAll(@Param("start") int start, @Param("limit") int limit) {
        return new Response(UserStatus.QUERY_SUCCESS, userMapper.queryLimitAll(start, limit));
    }

    /**
     * 查询拥有多少分页
     *
     * @param limit 一次查询条数
     */
    @GetMapping("/queryPage")
    public Response queryPage(@Param("limit") int limit) {
        return new Response(UserStatus.QUERY_SUCCESS, userMapper.queryPage(limit));
    }

}
