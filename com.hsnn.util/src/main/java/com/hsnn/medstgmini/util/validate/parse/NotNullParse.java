package com.hsnn.medstgmini.util.validate.parse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.validation.constraints.NotNull;

import com.hsnn.medstgmini.util.validate.bean.Validate;

public class NotNullParse implements IValidateParse {

	@Override
	public void parse(Validate validate, Field field, Annotation anno) {
		NotNull v = (NotNull) anno;
		validate.add(field.getName(), "required", true, v.message());
	}

}
