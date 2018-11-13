package io.matafe.guicesamples.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * External Service Implementation
 * 
 * @author matafe@gmail.com
 */
public class MyTestServiceImpl implements IMyExtService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    @Override
    public String process(final String name) {
	LOGGER.debug("processing {}", name);
	return getClass().getSimpleName() + "_" + name;
    }
}