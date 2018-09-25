package com.hsnn.medstgmini.util.excel.bean;

import java.io.InputStream;
import java.util.List;

public interface IExcelImport {
	<T> void execute(List<T> addList, List<T> errorList, InputStream is, Class<T> clazz) throws Exception;
}
