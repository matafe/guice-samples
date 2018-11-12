package io.matafe.guicesamples.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

/**
 * Simple Singleton Service Implementation
 * 
 * @author matafe@gmail.com
 */
@Singleton
public class MySingletonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySingletonService.class);

    public String process(final String name) {
	LOGGER.debug("processing {}", name);
	return getClass().getSimpleName() + "_" + name;
    }
}
