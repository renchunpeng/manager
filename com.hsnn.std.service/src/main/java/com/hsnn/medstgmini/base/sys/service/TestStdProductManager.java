package com.hsnn.medstgmini.base.sys.service;

import com.hsnn.medstgmini.base.sys.model.TestStdProduct;
import com.hsnn.medstgmini.util.Pagination;
/**
 * 
 * 测试药品录入  
 *
 * @ClassName: TestStdProductManager  
 * @author zhou.xy
 * @date 2016年2月24日 下午4:03:28  
 *
 */
public interface TestStdProductManager {
	/**
	 * 测试药品新增 
	 *
	 * @Title: addTestStdProduct 
	 * @param testStdProduct
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean addTestStdProduct(TestStdProduct testStdProduct);
	
	/**
	 * 测试药品更新
	 *
	 * @Title: updateTestStdProduct 
	 * @param testStdProduct
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean updateTestStdProduct(TestStdProduct testStdProduct);
	
	/**
	 * 根据主键获取TestStdProduct 
	 *
	 * @Title: getTestStdProduct 
	 * @param id
	 * @return 
	 * @return TestStdProduct
	 * @throws
	 */
	TestStdProduct getTestStdProduct(Integer id);
	
	/**
	 * 查询列表 
	 *
	 * @Title: getTestStdProductList 
	 * @param page
	 * @return 
	 * @return Pagination
	 * @throws
	 */
	Pagination getTestStdProductList(Pagination page);
}
