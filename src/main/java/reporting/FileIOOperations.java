package reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class FileIOOperations {

	public Properties readPropertyFile(String fileName) {

		Properties props = new Properties();
		InputStream is = null;

		// First try loading from the current directory
		try {
			File f = new File(new File(".", fileName).getAbsolutePath());
			is = new FileInputStream(f);
		} catch (Exception e) {
			is = null;
		}

		try {
			if (is == null) {
				// Try loading from classpath
				is = getClass().getResourceAsStream(fileName);
			}
			// Try loading properties from the file (if found)
			props.load(is);
			is.close();
		} catch (Exception e) {
		}
		return props;
	}
}
