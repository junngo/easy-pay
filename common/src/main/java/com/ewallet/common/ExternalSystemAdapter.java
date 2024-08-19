package com.ewallet.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/*
 * It conveys the meaning of 'ExternalSystemAdapter'.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ExternalSystemAdapter {
	@AliasFor(annotation = Component.class)
	String value() default "";
}
