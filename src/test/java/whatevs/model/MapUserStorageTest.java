package whatevs.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import whatevs.MapUserStorage;
import whatevs.User;


public class MapUserStorageTest {

	private MapUserStorage mus;
	private Map<String, User> mockmap;
	private User mockuser;

	@Before
	public void setUp(){
		mus = MapUserStorage.getInstance();
		mockmap = mock(HashMap.class);
		mockuser = mock(User.class);
		mus.setMap(mockmap);
	}

	@Test
	public void testGetInstanceReturnsNotNullWhenCalled() {
		assertNotNull(mus);
	}

	@Test
	public void getInstanceReturnsSameInstanceWhenCalledTwice(){
		assertSame(mus, MapUserStorage.getInstance());
	}

	@Test
	public void testAddVerifiesPutWasCalled(){
		when(mockuser.getUsername()).thenReturn("Key");
		mus.add(mockuser);
		verify(mockmap).put(mockuser.getUsername(),  mockuser);
	}

	@Test
	public void testGetVerifiesGetWasCalled(){
		mockuser = mus.get("Test");
		verify(mockmap).get("Test");
	}

	@Test
	public void testRemoveVerifiesRemoveWasCalled(){
		mus.remove("Test");
		verify(mockmap).remove("Test");
	}

}
