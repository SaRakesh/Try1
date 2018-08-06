

public class MyClassLoader {
	public static void main(String[] args) {
		try {
			Object.class.forName("A");
			Object.class.forName("B");
			Object.class.forName("C");
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
			// TODO: handle exception
		}
	}
}
