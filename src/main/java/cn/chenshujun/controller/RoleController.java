package cn.chenshujun.controller;

import cn.chenshujun.mapper.RoleMapper;
import cn.chenshujun.util.Response;
import cn.chenshujun.util.UserStatus;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由控制器
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/10/13
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/role")
public class RoleController {


    private final RoleMapper roleMapper;

    /**
     * 查询角色的权限列表
     *
     * @param id 角色id
     */
    @GetMapping("/queryIdByAuth")
    public Response queryIdByAuth(@Param("id") int id) {
        return new Response(UserStatus.QUERY_SUCCESS, roleMapper.queryIdByAuth(id));
    }
}
