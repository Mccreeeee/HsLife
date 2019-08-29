package com.hnsfdx.hslife.annotation;

import com.hnsfdx.hslife.async.EventType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteCache {
    String topic() default "";
}
