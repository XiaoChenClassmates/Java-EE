package cn.chenshujun.mapper;

import cn.chenshujun.model.Menu;

import java.util.List;

/**
 * 菜单表映射接口
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/11/29
 */
public interface MenuMapper {

    /**
     * 查询所有菜单
     *
     * @return 菜单列表
     */
    List<Menu> queryAll();
}
