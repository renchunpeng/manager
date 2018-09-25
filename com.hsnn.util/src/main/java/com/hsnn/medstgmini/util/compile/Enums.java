package com.hsnn.medstgmini.util.compile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 ** @category 枚举类注解
 ** @author qing.yunhui
 ** @date 2016年4月13日 下午5:52:51
 ***/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Enums {
	public Class<?> enumClz();
	public String name();
}
