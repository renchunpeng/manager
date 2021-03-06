package com.hsnn.medstgmini.util.validate.parse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.hibernate.validator.constraints.NotEmpty;

import com.hsnn.medstgmini.util.validate.bean.Validate;

/**
 * Created by ZXL on 2015/11/9.
 */
public class NotEmptyParse implements IValidateParse{

    @Override
    public void parse(Validate validate, Field field, Annotation anno) {
        NotEmpty v = (NotEmpty) anno;

        validate.add(field.getName(),"required",true,v.message());
    }
}
