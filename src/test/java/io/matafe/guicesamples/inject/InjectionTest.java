package io.matafe.guicesamples.inject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * Injection Tests
 * 
 * @author matafe@gmail.com
 */
public class InjectionTest {

    @Inject
    IMyService myService;
    
    @Inject
    IMyExtService myExtService;

    @Inject
    MySingletonService mySingletonService;

    @PayPal
    @Inject
    IMyPaymentService payPalPaymentService;

    @CreditCard
    @Inject
    IMyPaymentService creditCardPaymentService;

    @Named("db.user")
    @Inject
    String dbUser;

    @Named("db.max.pool.size")
    @Inject
    Integer maxPoolSize;

    @Inject
    MyPaymentFactory paymentFactory;

    @Before
    public void setup() {
	Injector injector = Guice.createInjector(new InjectBindingModule());
	injector.injectMembers(this);
    }

    @Test
    public void testInterfaceBinding() {
	final String name = "interfaceBinding";
	assertThat(myService.process(name), equalTo(MyServiceImpl.class.getSimpleName() + "_" + name));
    }
    
    @Test
    public void testInterfaceExternalBinding() {
	final String name = "interfaceExtBinding";
	assertThat(myExtService.process(name), equalTo(MyTestServiceImpl.class.getSimpleName() + "_" + name));
    }

    @Test
    public void testClassBinding() {
	final String name = "singletonBinding";
	assertThat(mySingletonService.process(name), equalTo(MySingletonService.class.getSimpleName() + "_" + name));
    }

    @Test
    public void testAnnotationBinding() {
	final double amount = 25;
	assertThat(payPalPaymentService.pay(amount),
		equalTo(MyPayPalPaymentServiceImpl.class.getSimpleName() + "_" + amount));
	assertThat(creditCardPaymentService.pay(amount),
		equalTo(MyCreditCardPaymentServiceImpl.class.getSimpleName() + "_" + amount));

    }

    @Test
    public void testNamedBinding() {
	assertThat(dbUser, equalTo("scott"));
	assertThat(maxPoolSize, equalTo(20));
    }

    @Test
    public void testMapBinding() {
	final double amount = 25;
	assertThat(paymentFactory.pay("PayPal", amount),
		equalTo(MyPayPalPaymentServiceImpl.class.getSimpleName() + "_" + amount));
	assertThat(paymentFactory.pay("CreditCard", amount),
		equalTo(MyCreditCardPaymentServiceImpl.class.getSimpleName() + "_" + amount));
	try {
	    paymentFactory.pay("Invalid", amount);
	    fail("Invalid type");
	} catch (IllegalArgumentException e) {
	    // OK
	}

    }

}
