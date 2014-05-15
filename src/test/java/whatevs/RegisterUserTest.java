package whatevs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class RegisterUserTest {

	@Test
	public void testRegisterUserAddsToStorage() {
		String[] temp = new String[] {"Temp"};
		Storage mockstore = mock(Storage.class);
		RegisterUser spy = spy(new RegisterUser(mockstore));
		User usr = mock(User.class);
		doReturn(usr).when(spy).createUser(any(String[].class));
		spy.registerUser(temp);
		verify(mockstore).add(usr);
	}

}
