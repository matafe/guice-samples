package io.matafe.guicesamples.interceptor;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Guice Module - Interceptor.
 * 
 * @author matafe@gmail.com
 */
public class InterceptorBindingModule extends AbstractModule {

    @Override
    protected void configure() {

	bindInterceptor(Matchers.any(), Matchers.annotatedWith(Logging.class), new LoggingInterceptor());

    }

}
