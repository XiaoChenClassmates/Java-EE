package cn.chenshujun.util;

import lombok.Getter;

/**
 * 用户异常响应枚举类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/22
 */
@Getter
public enum ErrorStatus implements Status {
    URL_NOT_EXISTS(200001, "页面不存在"),
    VALIDATION_ERROR(200002, "字段校验错误");


    private final int code;         // 状态码
    private final String message;       // 响应信息

    ErrorStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
