package com.hsnn.medstgmini.common.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.service.impl.AttachmentPlug;
import com.hsnn.medstgmini.base.sys.enums.YesOrNo;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;

public class GenericManagerImpl<T,PK> implements GenericManager<T, PK> {
	private static final Logger log = Logger.getLogger(GenericManagerImpl.class);
	
	@Autowired
	private GenericDao<T,PK> dao;
	@Autowired
	private AttachmentPlug attachmentPlug;
	public <T> T getDao() {
		return (T)dao;
	}
	
	@Override
	public int add(T model) {
		if(model instanceof ICreateInfo){
			SysUser user = SessionUtil.getSysUser();
			((ICreateInfo) model).setAddUserId(user.getUserId());
			((ICreateInfo) model).setAddUserName(user.getName() +"<" + user.getUserName() + ">");
			((ICreateInfo) model).setLastUpdateUserId(user.getUserId());
			((ICreateInfo) model).setLastUpdateUserName(user.getName() +"(" + user.getUserName() + ")");
		}
		printLog("插入",model,"单条插入");
		int saveCount = dao.save(model);
		if(model instanceof IAttachment<?>){
			attachmentPlug.processAttachment((IAttachment<PK>)model);
		}
		return saveCount;
	}

	@Override
	public int insertBatch(List<T> models) {
		printLog("插入",models,"批量插入");
		for (T model : models) {
			if(model instanceof ICreateInfo){
				SysUser user = SessionUtil.getSysUser();
				if(user != null) {
					((ICreateInfo) model).setAddUserId(user.getUserId());
					((ICreateInfo) model).setAddUserName(user.getName() +"<" + user.getUserName() + ">");
					((ICreateInfo) model).setLastUpdateUserId(user.getUserId());
					((ICreateInfo) model).setLastUpdateUserName(user.getName() +"(" + user.getUserName() + ")");
				}
			}
		}
		return dao.insertBatch(models);
	}
	
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
	public int insertBatchTemp(List<T> datas, String tableName, String isError) {
		printLog("插入",datas,"批量插入临时表");
		for (T model : datas) {
			if(model instanceof ICreateInfo){
				SysUser user = SessionUtil.getSysUser();
				((ICreateInfo) model).setAddUserId(user.getUserId());
				((ICreateInfo) model).setAddUserName(user.getName() +"(" + user.getUserName() + ")");
			}
		}
		return dao.insertBatchTemp(datas, tableName, isError);
	}

	@Override
	public T getById(PK id) {
		printLog("查询",id,"根据ID");
		
		T model = dao.get(id);
		if(model instanceof IAttachment<?>){
			attachmentPlug.processAttachment((IAttachment<PK>)model);
		}
		return model;
	}

	@Override
	public int deleteById(PK id) {
		printLog("删除",id,"根据ID");
		return dao.delete(id);
	}

	@Override
	public int updateById(T model) {
		if(model instanceof IUpdateInfo){
			SysUser user = SessionUtil.getSysUser();
			((IUpdateInfo) model).setLastUpdateUserId(user.getUserId());
			((IUpdateInfo) model).setLastUpdateUserName(user.getName() +"<" + user.getUserName() + ">");
		}
		printLog("更新",model,"根据ID");
		if(model instanceof IAttachment<?>){
			attachmentPlug.processAttachment((IAttachment<PK>)model);
		}
		return dao.update(model);
	}

	@Override
	public Pagination getList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<T> models = (Page<T>) dao.queryAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<T> getLists(Map<String, Object> params) {
		printLog("查询",params,"普通查询");
		return dao.queryAll(params);
	}
	
	@Override
	public Pagination getListWithImport(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<T> models = (Page<T>) dao.queryAllWithImport(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<T> getListWithImports(Map<String, Object> params) {
		printLog("查询",params,"普通查询");
		return dao.queryAllWithImport(params);
	}
	
	/**
	 * 可用于日志处理，打印一些通用的操作
	 * @param model
	 * @param params
	 * @param opt
	 * @param msg
	 */
	public void printLog(String opt,Object params,String msg){
		if(log.isDebugEnabled() && msg=="true"){
			Type type = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			System.out.println("实体："+type.getClass().getName());
			System.out.println("操作："+opt);
			System.out.println("参数："+JSON.toJSONString(params,SerializerFeature.NotWriteDefaultValue));
			System.out.println("信息："+msg);
		}
	}

	@Override
	public int getCount(Map<String, Object> params) {
		return dao.count(params);
	}
	
	@Override
	public int updateByParams(Map<String, Object> params, T entity) {
		if(entity instanceof IUpdateInfo){
			SysUser user = SessionUtil.getSysUser();
			if(user != null) {
				((IUpdateInfo) entity).setLastUpdateUserId(user.getUserId());
				((IUpdateInfo) entity).setLastUpdateUserName(user.getName() +"(" + user.getUserName() + ")");
			}
		}
		return dao.updateByParams(params, entity);
	}
	
	/**
	 * 自定义更新信息，用于定时任务更新信息，isAutoUpdateInfo=0
	 *
	 * @Title: updateByParams 
	 * @param params
	 * @param entity
	 * @param isAutoUpdateInfo 是否自动添加更新人信息
	 * @return int
	 */
	public int updateByParams2(Map<String, Object> params, T entity, Integer isAutoUpdateInfo) {
		int updateNum = 0;
		if(YesOrNo.YES.getKey().equals(isAutoUpdateInfo)) {
			updateNum = updateByParams(params, entity);
		} else {
			updateNum = dao.updateByParams(params, entity);
		}
		return updateNum;
	}

	@Override
	public int updateBySelective(T model) {
		return dao.updateBySelective(model);
	}
	
	@Override
	public int count(Map<String, Object> params) {
		return dao.count(params);
	}
}
