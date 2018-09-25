package com.hsnn.medstgmini.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GenericDao<T, PK> {
	
	@Deprecated
	T load(PK id);
	
	T get(PK id);
	
	@Deprecated
	List<T> findAll();
	
	@Deprecated
	int persist(T entity);
	
	int save(T entity);

	int update(T entity);
	
	int delete(PK id);
	
	List<T> queryAll(Map<String, Object> map);

	List<T> queryAllWithImport(Map<String, Object> map);
	
	int insertBatch(List<T> entity);
	
	@Deprecated
	void saveOrUpdate(T entity);
	
	int count(Map<String, Object> params);
	
	int updateByParams(@Param("params") Map<String,Object> params,@Param("model")T entity);
	
	int updateBySelective(T entity);
	
	/**
	 * 批量插入临时表   
	 *
	 * @Title: insertBatchTemp 
	 * @param datas
	 * @param tableName
	 * @param isError
	 * @return 
	 * @return int
	 * @throws
	 */
	int insertBatchTemp(@Param("models") List<T> datas, @Param("tableName") String tableName, @Param("isError") String isError);
}
