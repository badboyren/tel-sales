package com.cx.tel.sales.config.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

@Configuration
public class MybatisConfiguration {
	
	@Autowired
	private Environment env;
	
	 /***
     * plus 的性能优化,开发模式使用
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
    	PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    	if (!env.getProperty("profile").equals("prod_envrimont")) {
    		performanceInterceptor.setMaxTime(10000);//sql 最大执行时长
    		performanceInterceptor.setFormat(true);
    	} 
    	return performanceInterceptor;
    }
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
