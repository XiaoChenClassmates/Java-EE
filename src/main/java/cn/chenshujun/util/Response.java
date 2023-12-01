package cn.chenshujun.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回信息响应体类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/22
 */
@Data
public class Response implements Serializable {
    private Integer code;           // 状态码
    private String message;         // 提示信息
    private Object data;            // 有效载荷

    public Response(Status status, Object data) {
        if (status == null) {
            throw new NullPointerException("状态码为空");
        }
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }
}
