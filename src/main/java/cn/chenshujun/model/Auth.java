package cn.chenshujun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 路由实体类
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/9/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable {

    private int id;             // 主键
    private String name;        // 名称
    private String route;       // 路由

}
