package whatevs;

public class RegistrationValidator {

	private Storage store;

	public RegistrationValidator(Storage store) {
		this.store = store;
	}

	public boolean validate(String[] strarr) {
		
		return checkUsername(strarr[0]);
	}

	private boolean isStringNull(String str) {
		if (str == "" || str == null)
			return true;
		return false;
	}

	public boolean checkUsername(String str) {
		if (isStringNull(str))
			return false;
		if (store.get(str) != null)
			return false;
		return true;
	}

	public boolean checkPassword(String psswd, String confirm) {
		if (psswd == null)
			return false;
		if (psswd.length() < 6)
			return false;
		if (psswd != confirm)
			return false;
		return true;
	}

	public boolean checkFirstName(String str) {
		if (isStringNull(str))
			return false;
		if (str.matches(".*[^a-zA-Z .'-].*"))
			return false;
		return true;
	}

	public boolean checkLastName(String str) {
		if (isStringNull(str))
			return false;
		if (str.matches(".*[^a-zA-Z .'-].*"))
			return false;
		return true;
	}

}
