package com.bswen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotate a method to indicate if it's enabled or not,default is true
 * Created on 2019/6/13.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodStatus {
    //should enable or disable this method?
    public boolean enabled() default true;
}
