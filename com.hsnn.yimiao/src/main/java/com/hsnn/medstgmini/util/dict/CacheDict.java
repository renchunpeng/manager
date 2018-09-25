package com.hsnn.medstgmini.util.dict;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.base.std.service.StdDictManager;
import com.hsnn.medstgmini.base.sys.enums.YesOrNo;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/***
 ** @category 执行标准类型
 ** @author qing.yunhui
 ** @date 2016年3月7日 下午5:15:25
 ***/
//@Component("cacheDict")
public class CacheDict {
	private static final Logger log = Logger.getLogger(CacheDict.class);
	@Autowired
	private StdDictManager stdDictManager;
	private static Map<String, List<StdDict>> ALL_DICT = null;

	/**
	 * 根据字典type获取字典集合
	 * @param type
	 * @return List<StdDict>
	 */
	@SuppressWarnings("unchecked")
	public static List<StdDict> getSdtDictsByType(String type) {
		ShardedJedisPool shardedJedisPool = getShardedJedisPool();
		ShardedJedis sharedJedis =  null;
		Map<String, List<StdDict>> allDict = null;
		try {
			sharedJedis = shardedJedisPool.getResource();
			allDict = (Map<String, List<StdDict>>) unserialize(sharedJedis.get("ALL_DICT".getBytes()));
		} catch (Exception e) {
			log.error("",e);
		}finally {
			shardedJedisPool.returnResourceObject(sharedJedis);
		}
		return allDict.get(type);
	}
	
	/**
	 * 根据字典type和key获取字典对应名称
	 * @param type 字典类型
	 * @param key 
	 * @return String
	 */
	public static String getSdtDictsByTypeWithKey(String type,String key) {
		List<StdDict> dictList = getSdtDictsByType(type);
		if (dictList == null || dictList.size()<1) {
			return "";
		}
		for (StdDict dict : dictList) {
			if (dict.getDictionaryKey().equals(key)) {
				return dict.getDictionaryValue();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * 根据字典type获取字典集合JSON数据
	 * @Title: getDictJSON 
	 * @param type
	 * @return String
	 */
	public static String getDictJSON(String type) {
		List<StdDict> dicts = getSdtDictsByType(type);
		Map<Object, Object> map = new HashMap<Object, Object>();
		for(StdDict dict : dicts) {
			map.put(dict.getDictionaryKey(), dict.getDictionaryValue());
		}
		return JSON.toJSONString(map);
	}

	//@PostConstruct
	public  void init() {
		if (null==ALL_DICT) ALL_DICT = new HashMap<String, List<StdDict>>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("isUsing", YesOrNo.YES.getKey());
		List<StdDict> items = stdDictManager.getLists(param);
		ALL_DICT.clear();
		for (StdDict entity : items) {
			String type = entity.getType();
			List<StdDict> tempList = ALL_DICT.get(type);
			if (tempList == null) {
				tempList = new ArrayList<StdDict>();
			}
			tempList.add(entity);
			ALL_DICT.put(type, tempList);
		}
		ShardedJedisPool shardedJedisPool = getShardedJedisPool();
		ShardedJedis sharedJedis =  null;
		try {
			sharedJedis = shardedJedisPool.getResource();
			sharedJedis.set("ALL_DICT".getBytes(), serialize(ALL_DICT));
		} catch (Exception e) {
			log.error("",e);
		}finally {
			shardedJedisPool.returnResourceObject(sharedJedis);
		}
	}
	
	 public static byte[] serialize(Object object) {
	    	ObjectOutputStream oos = null;
	    	ByteArrayOutputStream baos = null;
	    	try {
		    	//序列化
		    	baos = new ByteArrayOutputStream();
		    	oos = new ObjectOutputStream(baos);
		    	oos.writeObject(object);
		    	byte[] bytes = baos.toByteArray();
		    	return bytes;
	    	} catch (Exception e) {
	    		log.error("Failed to serialize object to Redis Server:" + e.getMessage());
	    	}
	    	return null;
	    }
	    
	    public static Object unserialize(byte[] bytes) {
	    	ByteArrayInputStream bais = null;
	    	try {
		    	//反序列化
		    	bais = new ByteArrayInputStream(bytes);
		    	ObjectInputStream ois = new ObjectInputStream(bais);
		    	return ois.readObject();
	    	} catch (Exception e) {
	    		log.error("Failed to unserialize object from Redis Server:" + e.getMessage());
	    	}
	    	return null;
	    }
	    
		@SuppressWarnings("resource")
		private static ShardedJedisPool getShardedJedisPool(){
	    	ApplicationContext  ac = new ClassPathXmlApplicationContext("spring-redis.xml");
			ShardedJedisPool shardedJedisPool = (ShardedJedisPool) ac.getBean("shardedJedisPool");
			return shardedJedisPool;
	    }
}
