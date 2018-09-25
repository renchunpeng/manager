package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.TestStdProductDao;
import com.hsnn.medstgmini.base.sys.model.TestStdProduct;
import com.hsnn.medstgmini.base.sys.service.TestStdProductManager;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class TestStdProductManagerImpl implements TestStdProductManager {
	@Autowired
	private TestStdProductDao testStdProductDao;

	/**
	 * 查询列表
	 *
	 * @Title: getTestStdProductList
	 * @param page
	 * @return
	 * @return Pagination
	 * @throws
	 */
	public Pagination getTestStdProductList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());

		List<TestStdProduct> pagelist = testStdProductDao.queryAll(page.getConditions());
		Page<TestStdProduct> departments = (Page<TestStdProduct>) pagelist;
		page.setRows(departments);
		page.setRecords(departments.getTotal());
		return page;
	}

	/**
	 * 测试药品新增
	 *
	 * @Title: addTestStdProduct
	 * @param testStdProduct
	 * @return
	 * @return boolean
	 * @throws
	 */
	@Override
	public boolean addTestStdProduct(TestStdProduct testStdProduct) {
		testStdProductDao.save(testStdProduct);
		return true;
	}
	
	/**
	 * 测试药品更新
	 *
	 * @Title: updateTestStdProduct 
	 * @param testStdProduct
	 * @return 
	 * @return boolean
	 * @throws
	 */
	public boolean updateTestStdProduct(TestStdProduct testStdProduct) {
		testStdProductDao.update(testStdProduct);
		return true;
	}

	/**
	 * 根据主键获取TestStdProduct
	 *
	 * @Title: getTestStdProduct
	 * @param id
	 * @return
	 * @return TestStdProduct
	 * @throws
	 */
	public TestStdProduct getTestStdProduct(Integer id) {
		return testStdProductDao.get(id);
	}

}
