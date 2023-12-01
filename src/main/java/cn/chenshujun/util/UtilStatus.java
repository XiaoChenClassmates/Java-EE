package cn.chenshujun.util;

import lombok.AllArgsConstructor;

/**
 * 通用响应码
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/11/29
 */
@AllArgsConstructor
public enum UtilStatus implements Status {
    SUCCESS(1000001, "响应成功"),
    FAIL(1000002, "响应失败"),
    TOKEN_EXPIRED(1000003, "token过期"),
    TOKEN_VERIFY_FAIL(1000004, "token校验失败");

    private final int code;           // 状态码
    private final String message;     // 提示信息

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    @Override
    public int getCode() {
        return 0;
    }

    /**
     * 获取提示信息
     *
     * @return 提示信息
     */
    @Override
    public String getMessage() {
        return null;
    }
}
