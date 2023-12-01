package cn.chenshujun.mapper;

import cn.chenshujun.model.Auth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色操作映射接口
 *
 * @author shuchen
 * @version 1.0.0 2023/9/27
 */
public interface RoleMapper {

    /**
     * 查询角色的权限列表
     *
     * @param id 角色id
     * @return 权限列表
     */
    List<Auth> queryIdByAuth(@Param("id") int id);

}
