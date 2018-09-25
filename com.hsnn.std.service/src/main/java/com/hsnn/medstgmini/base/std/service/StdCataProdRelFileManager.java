package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdCataProdRelFile;
import com.hsnn.medstgmini.common.service.GenericManager;

/**
 * 
 *@category 药品目录关联表sevice接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdCataProdRelFileManager extends GenericManager<StdCataProdRelFile, String> {
	/**
	 * 药品添加
	 * @param form
	 * @return
	 */
	boolean addStdCataProdRelFile(StdCataProdRelFile sd);
	
	
}


