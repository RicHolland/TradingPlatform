package whatevs;

public class RegisterUser {

	private Storage store;

	public RegisterUser(Storage store) {
		this.store = store;
	}

	public void registerUser(String[] userDetails) {
		User newUser = createUser(userDetails);
		store.add(newUser);
	}

	public User createUser(String[] any) {
		return null;
	}

}
