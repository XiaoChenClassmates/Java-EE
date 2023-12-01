package cn.chenshujun.controller;

import cn.chenshujun.mapper.MenuMapper;
import cn.chenshujun.util.Response;
import cn.chenshujun.util.UtilStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单控制器
 *
 * @author XiaoChenClassmate
 * @version 1.0.0 2023/11/29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuMapper menuMapper;

    @Cacheable("menu")
    @GetMapping("/getAll")
    public Response getAll() {
        return new Response(UtilStatus.SUCCESS, menuMapper.queryAll());
    }
}
