package io.matafe.guicesamples.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Logging Annotation
 * 
 * @author matafe@gmail.com
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Logging {

}
