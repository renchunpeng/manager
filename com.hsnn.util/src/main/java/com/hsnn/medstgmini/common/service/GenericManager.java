package com.hsnn.medstgmini.common.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.util.Pagination;

public interface GenericManager<T, PK> {
	/**
	 * 新增
	 * @param model
	 * @return
	 */
	int add(T model);
	/**
	 * 批量插入
	 * @param models
	 * @return
	 */
	int insertBatch(List<T> models);
	/**
	 * 通过id修改
	 * @param id
	 * @return
	 */
	T getById(PK id);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteById(PK id);
	/**
	 * 根据id修改数据
	 * @param model
	 * @return
	 */
	int updateById(T model);
	
	/**
	 * 根据id修改不为空的数据
	 * @param model
	 * @return
	 */
	int updateBySelective(T model);
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	Pagination getList(Pagination page);
	/**
	 * 根据查询获取数据
	 * @param params
	 * @return
	 */
	List<T> getLists(Map<String,Object> params);
	
	Pagination getListWithImport(Pagination page);
	
	List<T> getListWithImports(Map<String, Object> params);
	
	/**
	 * 一般用于统计数量，主要解决问题
	 * 一个名称是否重复，某个类型有多少个等问题
	 * @param params
	 * @return
	 */
	int getCount(Map<String,Object> params);
	
	/**
	 * 根据自定义的条件 去更新相应的表
	 * @param params
	 * @param entity
	 * @return
	 */
	int updateByParams(Map<String,Object> params,T entity);
	
	/**
	 * 自定义更新信息 
	 *
	 * @Title: updateByParams 
	 * @param params
	 * @param entity
	 * @param isAutoUpdateInfo 是否自动添加更新人信息
	 * @return int
	 */
	int updateByParams2(Map<String, Object> params, T entity, Integer isAutoUpdateInfo);
	
	int count(Map<String, Object> params);
	
	/**
	 * 批量插入临时表   
	 *
	 * @Title: insertBatchTemp 
	 * @param datas
	 * @param tableName 插入表名
	 * @param isError 是否错误表
	 * @return 
	 * @return int
	 * @throws
	 */
	int insertBatchTemp(List<T> datas, String tableName, String isError);
}
