package com.hsnn.medstgmini.base.std.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdCataProdRelFileDao;
import com.hsnn.medstgmini.base.std.model.StdCataProdRelFile;
import com.hsnn.medstgmini.base.std.service.StdCataProdRelFileManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

/**
 * 
 *@category 药品目录管理接口实现类
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
@Service("StdCataProdRelFileManager")
public class StdCataProdRelFileManagerImpl  extends GenericManagerImpl<StdCataProdRelFile, String> implements StdCataProdRelFileManager {
	
	@Autowired
	private StdCataProdRelFileDao stdCataProdRelFileDao;
	
	
	@Override
	public boolean addStdCataProdRelFile(StdCataProdRelFile sd) {
		 return stdCataProdRelFileDao.save(sd)==1;
	}
	
	

}