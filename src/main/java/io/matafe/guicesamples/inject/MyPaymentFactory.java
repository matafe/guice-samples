package io.matafe.guicesamples.inject;

import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MyPaymentFactory {

    @Inject
    private Map<String, IMyPaymentService> paymentServiceMapping;

    public String pay(final String service, final double amount) {
	final IMyPaymentService paymentService = paymentServiceMapping.get(service);
	if (paymentService == null) {
	    throw new IllegalArgumentException("Invalid payment service: " + service);
	}
	return paymentService.pay(amount);
    }
}
