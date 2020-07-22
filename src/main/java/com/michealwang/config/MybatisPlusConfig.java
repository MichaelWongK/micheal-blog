package com.michealwang.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author  micheal.wang
 * @date  ${DATE} ${TIME}
 * @Email:wangmk13@163.com
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.michealwang.mapper")
public class MybatisPlusConfig {

    /**
     * PaginationIntercepto分页插件。
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
