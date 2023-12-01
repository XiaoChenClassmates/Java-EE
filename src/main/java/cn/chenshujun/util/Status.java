package cn.chenshujun.util;

/**
 * 返回状态信息接口
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/10/13
 */
public interface Status {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    int getCode();

    /**
     * 获取提示信息
     *
     * @return 提示信息
     */
    String getMessage();
}
