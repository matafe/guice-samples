package io.matafe.guicesamples.interceptor;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Interceptor Tests
 * 
 * @author matafe@gmail.com
 */
public class InterceptorTest {

    @Inject
    MyService myService;

    @Before
    public void setup() {
	Injector injector = Guice.createInjector(new InterceptorBindingModule());
	injector.injectMembers(this);
    }

    @Test
    public void testLoggingInterceptor() {
	myService.process("something");
	// nothing to assert... but check the logging for i.m.g.interceptor.MyService
    }
}
