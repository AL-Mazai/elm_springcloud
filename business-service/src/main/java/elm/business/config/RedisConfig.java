package elm.business.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建一个RedisTemplate对象
        RedisTemplate<Object, Object> template = new RedisTemplate<>();

        // 设置连接工厂，用于连接到Redis服务器
        template.setConnectionFactory(connectionFactory);

        // 使用FastJsonRedisSerializer来序列化和反序列化Redis中的值（对象）
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化Redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置值（对象）的序列化器为FastJsonRedisSerializer
        template.setValueSerializer(serializer);

        // 设置Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());

        // 设置Hash的值（对象）的序列化器为FastJsonRedisSerializer
        template.setHashValueSerializer(serializer);

        // 完成模板的属性设置
        template.afterPropertiesSet();

        // 返回配置好的RedisTemplate对象
        return template;
    }
}