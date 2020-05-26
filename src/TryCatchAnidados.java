
public class TryCatchAnidados {
	public static void main(String[] args) {
		try {
//			int invalid = 15/0;
		} catch (Exception e) {
			System.out.println("No se pudo dividir 15 entre 0.");
			try {
//				int invalid = 1/0;
			} catch (Exception e2) {
				System.out.println("No se pudo dividir 1 entre 0.");
			}
		}
		
		System.out.println("Segundo intento:\n\n");
		try {
			try {
//				int invalid = 15/0;
			} catch (ArithmeticException e) {
				System.out.println("Catch más específico");
			} catch (Exception e) {
				System.out.println("No se pudo dividir 15 entre 0.");
			} 
		} catch (Exception e) {
			System.out.println("mensaje del catch externo.");
		}
	}
}
