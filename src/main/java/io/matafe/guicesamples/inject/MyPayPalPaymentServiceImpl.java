package io.matafe.guicesamples.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple PayPal Payment Service Implementation
 * 
 * @author matafe@gmail.com
 */
public class MyPayPalPaymentServiceImpl implements IMyPaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyPayPalPaymentServiceImpl.class);

    @Override
    public String pay(final double amount) {
	LOGGER.debug("paid by paypal value: {}", amount);
	return getClass().getSimpleName() + "_" + amount;
    }

}
