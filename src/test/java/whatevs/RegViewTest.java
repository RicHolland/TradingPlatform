package whatevs;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class RegViewTest {

	@Test
	public void testGetUserInputCallsGetBufferedReader() throws IOException {
		InputStream in =new ByteArrayInputStream("Chris smells!".getBytes());
		RegView rv = new RegView(in);
		assertEquals(rv.getUserInput()[0], "Chris smells!");
	}

}
