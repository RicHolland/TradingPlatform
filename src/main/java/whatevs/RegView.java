package whatevs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RegView implements View {
	
	private InputStream is;

	public RegView(InputStream is) {
		this.is = is;
	}

	public String[] getUserInput() throws IOException {
		BufferedReader br = null;
		String[] test = {"","","","",""};
		try {
			br = getBufferedReader();
			
			test[0] = br.readLine();

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return test;
	}

	public BufferedReader getBufferedReader() {
		return new BufferedReader(new InputStreamReader(is));
	}

}
