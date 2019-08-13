package io.matafe.guicesamples.validation;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Validation Tests
 * 
 * @author matafe@gmail.com
 */
public class RuleValidatorTest {

    @Inject
    RuleValidator validator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
	Injector injector = Guice.createInjector(new ValidationBindingModule());
	injector.injectMembers(this);
    }

    @Test
    public void testValidate0() throws Exception {
	exception.expect(Exception.class);
	exception.expectMessage(containsString("ZERO"));
	validator.validate(0);
    }

    @Test
    public void testValidate1() throws Exception {
	validator.validate(1, 3);
    }

    @Test
    public void testValidate2() throws Exception {
	exception.expect(Exception.class);
	exception.expectMessage(containsString("Invalid"));
	validator.validate(2, 4);
    }
}
