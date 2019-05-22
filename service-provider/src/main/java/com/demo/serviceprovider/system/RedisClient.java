/*
package com.demo.serviceprovider.system;

import com.demo.serviceprovider.utils.ObjSerializeUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * redis
 * @author Jason
 * @description: TODO
 * @date 2019/5/21 14:24
 *//*

@Component
public class RedisClient {

    @Resource
    private JedisPool jedisPool;


    public RedisClient() {
    }

    public void setString(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public String getString(String key) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            String var3 = jedis.get(key);
            return var3;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            jedis.close();
        }

        return null;
    }

    public void expireString(String key, int seconds) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public void deleteString(String key) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.del(key);
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public void getString(String key, int seconds) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public void setObj(String key, Object obj) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.set(key.getBytes(), ObjSerializeUtil.serialize(obj));
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public Object getObj(String key) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            byte[] b = jedis.get(key.getBytes());
            Object var4;
            if (b != null) {
                var4 = ObjSerializeUtil.unserialize(b);
                return var4;
            }

            var4 = null;
            return var4;
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

        return null;
    }

    public void addRedisSet(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.sadd(key, new String[]{value});
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public String getRedisSet(String key) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            String var3 = jedis.smembers(key).toString();
            return var3;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            jedis.close();
        }

        return null;
    }

    public void addList(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.lpush(key, new String[]{value});
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            jedis.close();
        }

    }

    public List<String> getList(String key, int start, int end) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            List<String> list = jedis.lrange(key, (long)start, (long)end);
            List var6 = list;
            return var6;
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            jedis.close();
        }

        return null;
    }

    public void remListValue(String key, int count, String value) {
        Jedis jedis = null;

        try {
            jedis = this.jedisPool.getResource();
            jedis.lrem(key, (long)count, value);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            jedis.close();
        }

    }
}
*/
