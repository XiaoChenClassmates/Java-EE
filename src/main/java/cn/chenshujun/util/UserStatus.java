package cn.chenshujun.util;

import lombok.AllArgsConstructor;

/**
 * 用户返回信息枚举类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/10/13
 */
@AllArgsConstructor
public enum UserStatus implements Status {
    QUERY_SUCCESS(10001, "查询成功"),
    QUERY_FAIL(10002, "查询失败"),
    USER_EXISTS(10003, "用户已存在"),
    USER_NOT_EXISTS(10004, "用户不存在"),
    PASSWORD_ERROR(10005, "密码错误"),
    REGISTER_SUCCESS(10006, "注册成功"),
    REGISTER_FAIL(10007, "注册失败"),
    LOGIN_SUCCESS(10008, "登录成功"),
    LOGIN_FAIL(10009, "登录失败");


    private final int code;           // 状态码
    private final String message;     // 提示信息

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    @Override
    public int getCode() {
        return this.code;
    }

    /**
     * 获取提示信息
     *
     * @return 提示信息
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
