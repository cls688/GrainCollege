package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenglongsheng
 * @create 2021-06-28 22:44
 */
@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduConfig {

    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
