package whatevs;

import java.util.Map;

public class MapUserStorage implements Storage{

	private Map<String, User> map;

	private MapUserStorage(){}

	private static MapUserStorage mus = new MapUserStorage();

	public static MapUserStorage getInstance() {
		return mus;
	}

	public void add(User usr) {
		map.put(usr.getUsername(), usr);
	}

	public void setMap(Map<String, User> map){
		this.map = map;
	}

	public User get(String username) {
		return map.get(username);
	}

	public void remove(String username) {
		//System.out.println(map.remove(username));	//remove() returns object so can print out or return deleted user
		map.remove(username);
	}
}
