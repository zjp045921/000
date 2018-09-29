package com.woniuxy.class35.enumdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public  @interface Table {
	String value();
}
