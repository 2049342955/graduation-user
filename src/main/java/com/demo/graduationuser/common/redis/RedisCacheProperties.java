//package com.demo.graduationuser.common.redis;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import java.util.Map;
//
//@ConfigurationProperties("global.cache")
//public class RedisCacheProperties {
//    private long expire = 86400L;
//    private String host;private int port;
//
//    private int database;
//    private String password;
//    private int maxTotal = 100;
//    private int maxIdle = 100;
//    private long maxWaitMillis = 1000L;
//    private Map<String, Long> expires;
//
//    public RedisCacheProperties() {
//    }
//
//    public long getExpire() {
//        return this.expire;
//    }
//
//    public void setExpire(long expire) {
//        this.expire = expire;
//    }
//
//    public String getHost() {
//        return this.host;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public int getPort() {
//        return this.port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public int getDatabase() {
//        return this.database;
//    }
//
//    public void setDatabase(int database) {
//        this.database = database;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getMaxTotal() {
//        return this.maxTotal;
//    }
//
//    public void setMaxTotal(int maxTotal) {
//        this.maxTotal = maxTotal;
//    }
//
//    public int getMaxIdle() {
//        return this.maxIdle;
//    }
//
//    public void setMaxIdle(int maxIdle) {
//        this.maxIdle = maxIdle;
//    }
//
//    public long getMaxWaitMillis() {
//        return this.maxWaitMillis;
//    }
//
//    public void setMaxWaitMillis(long maxWaitMillis) {
//        this.maxWaitMillis = maxWaitMillis;
//    }
//
//    public Map<String, Long> getExpires() {
//        return this.expires;
//    }
//
//    public void setExpires(Map<String, Long> expires) {
//        this.expires = expires;
//    }
//}
