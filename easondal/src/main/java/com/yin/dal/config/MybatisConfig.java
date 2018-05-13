package com.yin.dal.config;

import com.yin.dal.plugins.UserPlugin;
import com.yin.dal.typehandlers.UserTypeHandler;
import org.apache.ibatis.executor.loader.cglib.CglibProxyFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.yin.dal.dao")
public class MybatisConfig {

    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    @Lazy(false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new UserTypeHandler()});
//        sqlSessionFactoryBean.setTypeHandlersPackage("com.gupao.dal.typehandles");
       // sqlSessionFactoryBean.setPlugins(new Interceptor[]{new UserPlugin()});
        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor()});
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
        //lazy loading switch
   /*     factory.getConfiguration().setLazyLoadingEnabled(true);
        factory.getConfiguration().setAggressiveLazyLoading(false);
        factory.getConfiguration().setProxyFactory(new CglibProxyFactory());*/
        return factory;
    }
}
