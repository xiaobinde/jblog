package com.blog.common.service;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Created by liuhb on 2017/1/11.
 */
@Service
public class RedisService {

    @Resource
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<T,ShardedJedis> fun){
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
            if (null != shardedJedis)
                shardedJedis.close();
        }
        return null;
    }

    /**
     * 执行set操作
     * @param key
     * @param value
     * @return
     */
    public String set(final String key,final  String value){
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.set(key,value);
            }
        });
    }

    /**
     * 执行get操作
     * @param key
     * @return
     */
    public String get(final String key){
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.get(key);
            }
        });
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public Long del(final String key){
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.del(key);
            }
        });
    }

    /**
     * 设置生存时间，单位为秒
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key,final Integer seconds){
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.expire(key,seconds);
            }
        });
    }

    /**
     * 设置string 类型的值，并且设置指定生存时间，单位为秒
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key,final  String value,final Integer seconds){
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                String result = shardedJedis.set(key,value);
                //设置生存时间
                shardedJedis.expire(key,seconds);
                return result;
            }
        });
    }

}
