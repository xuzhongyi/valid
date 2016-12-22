package com.test.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PamaMethodValid{
	
	public PamaMethod pamaMethod() default PamaMethod.NULL;
	
	public PamaType pamaType() default PamaType.NULL;
}
