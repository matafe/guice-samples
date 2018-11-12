package io.matafe.guicesamples.interceptor;

import com.google.inject.Singleton;

/**
 * Simple Singleton Service Implementation
 * 
 * @author matafe@gmail.com
 */
@Singleton
public class MyService {

    @Logging
    public String process(final String name) {
	return getClass().getSimpleName() + "_" + name;
    }

}
