package br.com.store.proxy.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Created by ramon.cidade on 15/05/2017.
 */
@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

    @Bean
    RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }


}
