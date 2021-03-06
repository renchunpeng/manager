package com.hsnn.medstgmini.util.validate.parse;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.validation.constraints.Max;

import com.hsnn.medstgmini.util.validate.bean.Validate;

/**
 * Created by ZXL on 2015/11/9.
 */
public class MaxParse implements IValidateParse {

    @Override
    public void parse(Validate validate, Field field, Annotation anno) {
        Max v = (Max) anno;
        validate.add(field.getName(), "max",v.value(), v.message());
    }

}
