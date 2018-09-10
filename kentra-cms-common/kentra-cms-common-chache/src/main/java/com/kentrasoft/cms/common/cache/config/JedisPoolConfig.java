//package com.kentrasoft.cms.common.cache.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
////@ConfigurationProperties(prefix="spring.redis.pool")
//@Configuration
//@EnableCaching
//public class JedisPoolConfig {
//
//    //    @Bean
////    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory factory) {
////        RedisTemplate redisTemplate = new RedisTemplate();
////        redisTemplate.setConnectionFactory(factory);
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////        redisTemplate.setValueSerializer(new RedisObjectSerializer());
////
////        return redisTemplate;
////    }
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//
//    @Bean
//    public RedisConnectionFactory redisCF() {
//        JedisConnectionFactory jcf = new JedisConnectionFactory();
//        jcf.setHostName(redisHost);
//        jcf.setPort(redisPort);
//        jcf.afterPropertiesSet();
//        jcf.setUsePool(true);
//        return jcf;
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setKeySerializer(new StringRedisSerializer());//指定key的序列化
//        //template.setValueSerializer(new )
//        template.setConnectionFactory(redisCF());
//        return template;
//    }
//
//}
