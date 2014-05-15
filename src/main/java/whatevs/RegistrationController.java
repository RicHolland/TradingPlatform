package whatevs;

public class RegistrationController {

	private View view;
	private RegistrationValidator validator;
	private RegisterUser register;

	public RegistrationController(View view, RegistrationValidator validator, RegisterUser register) {
		this.view = view;
		this.validator = validator;
		this.register = register;
	}

	public void handle() {
		String[] temp =view.getUserInput();
		if (validator.validate(temp)) {
			register.registerUser(temp);
		}
		
	}

}