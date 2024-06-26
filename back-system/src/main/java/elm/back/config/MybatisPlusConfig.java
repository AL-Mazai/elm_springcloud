//package elm.back.config;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.core.MybatisConfiguration;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
///**
// * MyBatis-Plus配置类
// */
//@Configuration
//@EnableTransactionManagement
//@MapperScan("elm.back.mapper")
//public class MybatisPlusConfig {
//
//    @Bean("sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
//
//        // 未使用MyBatis-Plus的分页插件的小伙伴可忽略此部分
//        // MybatisPlus内部拦截器
//        // 为自动分页插件设置DB类型
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        // 可添加自定义拦截器，没有自定义拦截器的小伙伴可忽略此部分
//        // MybatisConfiguration
//        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
//        mybatisConfiguration.addInterceptor(mybatisPlusInterceptor);
//
//        // 开启缓存，可自行选择
//        mybatisConfiguration.setCacheEnabled(true);
//
//        // 使用MybatisSqlSessionFactoryBean
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//
//        // 设置数据源
//        sqlSessionFactoryBean.setDataSource(dataSource);
//
//        // 添加MybatisConfiguration
//        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
//
//
//        // 设置mapper相应的xml路径
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/*.xml"));
//
//        // 返回MybatisSqlSessionFactoryBean从而替代原生的sqlSessionFactory
//        return sqlSessionFactoryBean.getObject();
//    }
//
//}
//
