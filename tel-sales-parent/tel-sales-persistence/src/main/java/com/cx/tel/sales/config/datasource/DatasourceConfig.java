package com.cx.tel.sales.config.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Configuration
public class DatasourceConfig {
//	 /**
//     * 业务数据源
//     * @return
//     */
//    @Bean("dataSource")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }

    /**
     * 事务管理（可以不写）
     * @return
     */
    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 事务隔离级别（默认 ）
     * @return
     */
    @Bean("defaultTransDefinition")
    public DefaultTransactionDefinition defaultTransactionDefinition(){
        return new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
    }
}
