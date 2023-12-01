package cn.chenshujun.config;

import cn.chenshujun.service.TokenInterceptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 应用主配置类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/22
 */
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final TokenInterceptorService tokenInterceptor;

    /**
     * 运行跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 路由
                .allowedOrigins("*") // 来源
                .allowedHeaders("*") // 请求头
                .allowedMethods("*") // 请求方法
                .allowCredentials(false);
    }

    /**
     * 配置拦截器、拦截路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
