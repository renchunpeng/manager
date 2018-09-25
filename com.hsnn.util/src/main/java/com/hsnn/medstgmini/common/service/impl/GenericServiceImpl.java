package com.hsnn.medstgmini.common.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.common.service.GenericService;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author 应晓川
 * @since 2016年2月25日13:12:02
 */
public abstract class GenericServiceImpl<Model, PK extends Serializable> implements GenericService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericDao<Model, PK> getDao();

	@Override
	public int insert(Model model) {
		 return getDao().save(model);
	}

	@Override
	public int update(Model model) {
		 return getDao().update(model);
	}

	@Override
	public Model selectById(PK id) {
		 return getDao().get(id);
	}

	@Override
	public Model selectOne() {
		return null;
	}

	@Override
	public List<Model> selectList() {
		return null;
	}

	@Override
	public List<Model> queryAll(Map<String, Object> map) {
		return getDao().queryAll(map);
	}
    
    
    

}
