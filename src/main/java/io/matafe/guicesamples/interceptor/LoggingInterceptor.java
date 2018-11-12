package io.matafe.guicesamples.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging Interceptor Implementation
 * 
 * @author matafe@gmail.com
 */
public class LoggingInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {

	Object result = null;
	try {
	    LOGGER.debug("init method execution: " + invocation.getMethod().getName() + "(...)  - args: {}",
		    invocation.getArguments());
	    result = invocation.proceed();
	} finally {
	    LOGGER.debug("end method execution: " + invocation.getMethod().getName());
	}

	return result;
    }

}
