package whatevs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class RegistrationValidatorTest {

	private Storage mockstore = mock(Storage.class);
	private User mockusr = mock(User.class);
	private RegistrationValidator spyrv = spy(new RegistrationValidator(mockstore));
	private String[] right = new String[] {"username", "password", "password", "first name", "last name"};
	private String[] wrong = new String[] {"", "", "2shrt", "f1r5t nam3", "1a5t nam3"};

	@Test	//1
	public void testCheckUsernameReturnsFalseWhenUsernameIsBlankString() {
		assertFalse(spyrv.checkUsername(wrong[0]));
	}

	@Test	//2
	public void testCheckUsernameReturnsFalseWhenUsernameInStorage() {
		doReturn(mockusr).when(mockstore).get("Test");
		assertFalse(spyrv.checkUsername("Test"));
	}

	@Test	//3
	public void testCheckUsernameReturnsTrueWhenUsernameNotBlankOrInStorage() {
		doReturn(null).when(mockstore).get(right[0]);
		assertTrue(spyrv.checkUsername(right[0]));
	}

	@Test	//4
	public void testCheckPasswordReturnsFalseWhenPassedEmptyString() {
		assertFalse(spyrv.checkPassword(wrong[1], wrong[1]));
	}

	@Test	//5
	public void testCheckPasswordReturnsFalseWhenPassedNull() {
		assertFalse(spyrv.checkPassword(null, null));
	}

	@Test	//6
	public void testCheckPasswordReturnsFalseWhenPassedStringOfLength5() {
		assertFalse(spyrv.checkPassword(wrong[2], wrong[2]));
	}

	@Test	//7
	public void testCheckPasswordReturnsFalseWhenPsswdValidAndConfirmPsswdNotSame() {
		assertFalse(spyrv.checkPassword(right[1], wrong[2]));
	}

	@Test	//8
	public void testCheckPasswordReturnsTrueWhenPsswdValidAndConfirmPsswdTheSame() {
		assertTrue(spyrv.checkPassword(right[1], right[2]));
	}

	@Test	//9
	public void testCheckFirstNameReturnsFalseWhenPassedEmptyString() {
		assertFalse(spyrv.checkFirstName(wrong[0]));
	}

	@Test	//10
	public void testCheckFirstNameReturnsTrueWhenStringOnlyLetters() {
		assertTrue(spyrv.checkFirstName(right[3]));
	}

	@Test	//11
	public void testCheckFirstNameReturnsFalseWhenStringContainsNumbers() {
		assertFalse(spyrv.checkFirstName(wrong[3]));
	}

	@Test	//12
	public void testCheckLastNameReturnsFalseWhenPassedEmptyString() {
		assertFalse(spyrv.checkLastName(wrong[0]));
	}

	@Test	//13
	public void testCheckLastNameReturnsTrueWhenStringOnlyLetters() {
		assertTrue(spyrv.checkLastName(right[4]));
	}

	@Test	//14
	public void testCheckLastNameReturnsFalseWhenStringContainsNumbers() {
		assertFalse(spyrv.checkLastName(wrong[4]));
	}

}
