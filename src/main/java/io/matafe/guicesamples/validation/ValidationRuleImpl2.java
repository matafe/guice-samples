package io.matafe.guicesamples.validation;

/**
 * Validation Rule 2
 * 
 * @author matafe@gmail.com
 */
public class ValidationRuleImpl2 implements ValidationRule {

    @Override
    public void validate(int val) throws Exception {
	if (val % 2 == 0) {
	    throw new Exception("Invalid = " + val);
	}
    }

}
