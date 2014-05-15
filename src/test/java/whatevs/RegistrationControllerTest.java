package whatevs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class RegistrationControllerTest {

	private View mockview;
	private RegistrationController regcon;
	private RegistrationValidator mockvalidator;
	private RegisterUser mockregister;
	private String[] test = new String[] {"Test"};

	@Before
	public void setUp(){
		mockview = mock(View.class);
		mockvalidator = mock(RegistrationValidator.class);
		mockregister = mock(RegisterUser.class);
		regcon = new RegistrationController(mockview, mockvalidator, mockregister);
	}
	
	@Test	//1
	public void testHandleCallsGetUserInput() {
		regcon.handle();
		verify(mockview).getUserInput();
	}

	@Test	//2
	public void testHandleCallsValidatorWithStringArray() {
		when(mockview.getUserInput()).thenReturn(test);
		regcon.handle();
		verify(mockvalidator).validate(test);
	}

	@Test	//3
	public void testHandleCallsRegisterUserWhenValidateReturnsTrue() {
		when(mockview.getUserInput()).thenReturn(test);
		when(mockvalidator.validate(test)).thenReturn(true);
		regcon.handle();
		verify(mockregister).registerUser(test);
	}

	@Test	//4
	public void testHandleDoesntCallRegisterUserWhenValidateReturnsFalse() {
		when(mockvalidator.validate(any(String[].class))).thenReturn(false);
		regcon.handle();
		verify(mockregister, never()).registerUser(any(String[].class));
	}

}
