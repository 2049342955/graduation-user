//package com.demo.graduationuser.common.redis;
//
////import com.demo.puddconfig.redis.RedisCacheProperties;
//import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
//import com.demo.core.cache.HashRedisCacheManager;
//import com.demo.core.redis.CompressJackson2JsonRedisSerializer;
//import com.demo.core.redis.RedisCacheUtil;
//import com.demo.core.redis.RedisTemplateHolder;
//import com.demo.core.redis.lock.RedissonLockHelper;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//@EnableCaching
//@ConditionalOnProperty(
//        name = {"global.cache.host"}
//)
//@EnableConfigurationProperties({RedisCacheProperties.class})
//public class RedisConfig extends CachingConfigurerSupport {
//    @Autowired
//    private RedisCacheProperties redisCacheProperties;
//
//    public RedisConfig() {
//    }
//
//    @Bean
//    public RedisCacheUtil redisCacheUtil(RedisTemplate redisTemplate) {
//        return new RedisCacheUtil(redisTemplate);
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        if (redisTemplate == null) {
//            return null;
//        } else {
//            HashRedisCacheManager redisCacheManager = new HashRedisCacheManager(redisTemplate);
//            redisCacheManager.setDefaultExpiration(this.redisCacheProperties.getExpire());
//            redisCacheManager.setExpires(this.redisCacheProperties.getExpires());
//            return redisCacheManager;
//        }
//    }
//
//    @Bean(
//            destroyMethod = "shutdown"
//    )
//    public RedissonClient redisson() {
//        Config config = new Config();
//        ((SingleServerConfig)config.useSingleServer().setAddress(this.redisCacheProperties.getHost() + ":" + this.redisCacheProperties.getPort()).setDatabase(this.redisCacheProperties.getDatabase()).setPassword(this.redisCacheProperties.getPassword())).setConnectionPoolSize(this.redisCacheProperties.getMaxTotal()).setSubscriptionConnectionPoolSize(this.redisCacheProperties.getMaxTotal());
//        return Redisson.create(config);
//    }
//
//    @Bean
//    public RedissonLockHelper redissonLockHelper() {
//        RedissonLockHelper helper = new RedissonLockHelper(this.redisson());
//        return helper;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxWaitMillis(this.redisCacheProperties.getMaxWaitMillis());
//        jedisPoolConfig.setMaxIdle(this.redisCacheProperties.getMaxIdle());
//        jedisPoolConfig.setMaxTotal(this.redisCacheProperties.getMaxTotal());
//        jedisPoolConfig.setBlockWhenExhausted(false);
//        jedisPoolConfig.setMaxWaitMillis(this.redisCacheProperties.getMaxWaitMillis());
//        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
//        factory.setHostName(this.redisCacheProperties.getHost());
//        factory.setPort(this.redisCacheProperties.getPort());
//        factory.setDatabase(this.redisCacheProperties.getDatabase());
//        factory.setPassword(this.redisCacheProperties.getPassword());
//        factory.afterPropertiesSet();
//        RedisTemplate template = new RedisTemplate();
//        CompressJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new CompressJackson2JsonRedisSerializer(Object.class);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
//        objectMapper.enableDefaultTyping(DefaultTyping.NON_FINAL);
//        template.setConnectionFactory(factory);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        template.setKeySerializer(stringRedisSerializer);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(stringRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        RedisTemplateHolder.holdRedisTemplate(template);
//        return template;
//    }
//}
