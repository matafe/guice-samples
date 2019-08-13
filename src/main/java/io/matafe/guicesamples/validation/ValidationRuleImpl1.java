package io.matafe.guicesamples.validation;

/**
 * Validation Rule 1
 * 
 * @author matafe@gmail.com
 */
public class ValidationRuleImpl1 implements ValidationRule {

    @Override
    public void validate(int val) throws Exception {
	if (val == 0) {
	    throw new Exception("ZERO");
	}
    }

}
