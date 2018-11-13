package io.matafe.guicesamples.inject;

import com.google.inject.AbstractModule;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;

/**
 * Guice Module - Injection.
 * 
 * @author matafe@gmail.com
 */
public class InjectBindingModule extends AbstractModule {

    @Override
    protected void configure() {

	// linked binding - interface with one implementation
	bind(IMyService.class).to(MyServiceImpl.class);

	bindExternal(IMyExtService.class, "io.matafe.guicesamples.inject.MyTestServiceImpl", MyServiceImpl.class);

	// annotation binding - interface with many implementation
	bind(IMyPaymentService.class).annotatedWith(PayPal.class).to(MyPayPalPaymentServiceImpl.class);
	bind(IMyPaymentService.class).annotatedWith(CreditCard.class).to(MyCreditCardPaymentServiceImpl.class);

	// instance binding - String, Integer binding...
	bind(String.class).annotatedWith(Names.named("db.user")).toInstance("scott");
	bind(Integer.class).annotatedWith(Names.named("db.max.pool.size")).toInstance(20);

	// map binder
	MapBinder<String, IMyPaymentService> mapBinder = MapBinder.newMapBinder(binder(), String.class,
		IMyPaymentService.class);
	mapBinder.addBinding("PayPal").to(MyPayPalPaymentServiceImpl.class);
	mapBinder.addBinding("CreditCard").to(MyCreditCardPaymentServiceImpl.class);

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <I, T extends I> ScopedBindingBuilder bindExternal(final Class<I> interfaceClass, final String externalImplementation,
	    final Class<T> internalImplementation) {
	Class extServiceImpl;
	try {
	    extServiceImpl = Class.forName(externalImplementation);
	} catch (ClassNotFoundException e) {
	    extServiceImpl = internalImplementation;
	}
	return bind(interfaceClass).to(extServiceImpl);
    }

}
