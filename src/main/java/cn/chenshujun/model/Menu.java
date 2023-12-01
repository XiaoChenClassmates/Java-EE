package cn.chenshujun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜单实体类
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/11/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    private int id;             // 主键
    private String name;        // 名称
    private String url;         // 路由

}
