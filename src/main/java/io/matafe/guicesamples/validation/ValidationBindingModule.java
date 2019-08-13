package io.matafe.guicesamples.validation;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * Guice Module - Validator.
 * 
 * @author matafe@gmail.com
 */
public class ValidationBindingModule extends AbstractModule {

    @Override
    protected void configure() {

	// multi binder
	Multibinder<ValidationRule> multibinder = Multibinder.newSetBinder(binder(), ValidationRule.class);
	multibinder.addBinding().to(ValidationRuleImpl1.class);
	multibinder.addBinding().to(ValidationRuleImpl2.class);
    }

}
