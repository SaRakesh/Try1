import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Kalu {
	public static void main(String[] args) {
		System.out.println("write some program");
		Properties properties = new Properties();
		File file = new File("MyProperty.properties");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			InputStream inStream = new FileInputStream(file);
			properties.load(inStream);
			inStream.close();
			int n = properties.size();
			// properties.
			for (int i = n; i < n + 10; i++)
				properties.setProperty("key of " + i, "value is " + i + " :");
			for (int i = 0; i < n + 10; i++)
				System.out
						.println("for key 'key of " + i + " value is '" + properties.getProperty("key of " + i) + "'");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				FileOutputStream out = new FileOutputStream(file);
				properties.store(out, null);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
