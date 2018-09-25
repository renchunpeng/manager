package com.hsnn.medstgmini.util.validate.parse;


import org.hibernate.validator.constraints.Email;

import com.hsnn.medstgmini.util.validate.bean.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by ZXL on 2015/11/9.
 */
public class EmailParse implements IValidateParse{

    @Override
    public void parse(Validate validate, Field field, Annotation anno) {
        Email v = (Email) anno;

        validate.add(field.getName(),"email",true,v.message());
    }
}
