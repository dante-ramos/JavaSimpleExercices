
public class GettingClassNameFromObject {

	public GettingClassNameFromObject () {
		System.out.println("Creating object");
	}
	public static void main(String[] args) {
		GettingClassNameFromObject obj = new GettingClassNameFromObject();
		System.out.println(obj.getClass().getName());
		System.out.println(obj.getClass().getClassLoader());

	}

}
