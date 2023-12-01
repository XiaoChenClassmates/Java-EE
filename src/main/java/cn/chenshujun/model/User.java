package cn.chenshujun.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户实体类
 *
 * @author shuchen
 * @version 1.0.0 2023/9/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private int id;               // 主键
    private int age;              // 年纪
    private int rid;              // 角色
    private String username;      // 用户
    private String rolename;      // 角色
    @JsonIgnore
    private String password;      // 密码
    @JsonIgnore
    private String sort;          // 加密盐
    @JsonIgnore
    private Date deleteTime;      // 软删除

}
