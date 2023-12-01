package cn.chenshujun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 角色实体类
 *
 * @author shuchen
 * @version 1.0.0 2023/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private int id;                     // 主键
    private String name;                // 角色昵称
    private List<Auth> authList;        // 权限路由

}
