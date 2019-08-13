package io.matafe.guicesamples.validation;

/**
 * Validation Rule
 * 
 * @author matafe@gmail.com
 */
public interface ValidationRule {

    void validate(int val) throws Exception;

}
