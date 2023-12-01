package cn.chenshujun.mapper;

import cn.chenshujun.model.User;
import cn.chenshujun.util.Crypto;
import cn.chenshujun.util.Status;
import cn.chenshujun.util.UserStatus;
import org.apache.ibatis.annotations.Param;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * 用户操作映射接口
 *
 * @author shuchen
 * @version 1.0.0 2023/9/27
 */
public interface UserMapper {

    /**
     * 用户登录
     *
     * @param username 用户名称
     * @param password 用户密码
     * @return 返回用户信息的所有数据
     */
    default User login(String username, String password) throws NoSuchAlgorithmException {
        User user = this.queryUsernameByAll(username);
        if (user == null || user.getDeleteTime() != null || !Objects.equals(user.getPassword(), Crypto.md5(Crypto.md5(password) + user.getSort()))) {
            return null;
        }
        return user;
    }

    /**
     * 用户注册
     *
     * @param username 用户名称
     * @param password 用户密码
     * @return 状态码
     */
    default Status register(String username, String password) throws NoSuchAlgorithmException {
        User user = this.queryUsernameByAll(username);
        if (user != null) {
            // 账户存在
            if (user.getDeleteTime() == null) {
                return UserStatus.USER_EXISTS;
            }
            // 账户被删除
            password = Crypto.md5(password);    // 加密密码
            var sort = password.substring(14, 20);  // 加密盐
            password = Crypto.md5(password + sort); // 最终密码
            if (this.addUserUpatde(username, password, sort, user.getId()) == 0) {
                return UserStatus.REGISTER_FAIL;
            }
            return UserStatus.REGISTER_SUCCESS;
        }
        // 账户不存在
        password = Crypto.md5(password);    // 加密密码
        var sort = password.substring(14, 20);  // 加密盐
        password = Crypto.md5(password + sort); // 最终密码
        if (this.addUser(username, password, sort) == 0) {
            return UserStatus.REGISTER_FAIL;
        }
        return UserStatus.REGISTER_SUCCESS;
    }

    /**
     * 用户注册(用户已删除)
     *
     * @param id       用户ID
     * @param username 用户名称
     * @param password 用户密码
     * @param sort     加密盐
     * @return 0 - 失败, 1 - 成功
     */
    default int addUserUpatde(@Param("username") String username, @Param("password") String password, @Param("sort") String sort, @Param("id") int id) {
        return 0;
    }

    ;

    /**
     * 通过用户名称查询用户所有信息
     *
     * @param username 用户名称
     * @return 返回用户信息的所有数据
     */
    User queryUsernameByAll(String username);

    /**
     * 通过用户ID查询用户所有信息
     *
     * @param id 用户ID
     * @return 返回用户信息的所有数据
     */
    User queryIdByAll(@Param("id") int id);

    /**
     * 添加用户
     *
     * @param sort     加密盐
     * @param username 用户名称
     * @param password 用户密码
     * @return 0 - 失败, 1 - 成功
     */
    int addUser(@Param("username") String username, @Param("password") String password, @Param("sort") String sort);


    /**
     * 查询拥有多少分页
     *
     * @param limit 一次查询条数
     * @return 分页数目
     */
    int queryPage(@Param("limit") int limit);

    /**
     * 分页查询所有用户
     *
     * @param start 分页起始id
     * @param limit 一次查询条数
     * @return 用户列表
     */
    List<User> queryLimitAll(@Param("start") int start, @Param("limit") int limit);

}
