package io.matafe.guicesamples.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple Credit Card Payment Service Implementation
 * 
 * @author matafe@gmail.com
 */
public class MyCreditCardPaymentServiceImpl implements IMyPaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyCreditCardPaymentServiceImpl.class);

    @Override
    public String pay(final double amount) {
	LOGGER.debug("paid by credit card value: {}", amount);
	return getClass().getSimpleName() + "_" + amount;
    }

}
