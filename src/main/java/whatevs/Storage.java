package whatevs;

public interface Storage {

	public abstract void add(User user);

	public abstract User get(String username);

	public abstract void remove(String username);

}
