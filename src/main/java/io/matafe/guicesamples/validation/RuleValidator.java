package io.matafe.guicesamples.validation;

import java.util.Set;

import javax.inject.Inject;

/**
 * Simple Rule Validator
 * 
 * @author matafe@gmail.com
 */
public class RuleValidator {

    @Inject
    private Set<ValidationRule> validationRules;

    public void validate(int... values) throws Exception {
	for (final ValidationRule validationRule : validationRules) {
	    for (final int val : values) {
		validationRule.validate(val);
	    }
	}
    }

}
