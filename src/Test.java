import java.util.stream.*;

public class Test {

	public static void main(String[] args) {
		//IntStream.range(1, 10).forEach(x -> System.out.println(x));
//		Long x = 2L, y = 4L;
//		Long resultLong = LongStream.rangeClosed(x,y).reduce(1L, (a,b) -> a*b);
//		System.out.println(resultLong);
		
//		List<String> list =Arrays.asList("hola", "mundo", "mundo", "hola");
//		List<String>newList = (List<String>) list.stream().distinct().collect(Collectors.toList());
//		newList.stream().forEachOrdered(x -> System.out.println(x));
		
		final String prefix="pr ef", suffix="su ff";
		String str = "  my String  ";
		System.out.println(Stream.of(prefix+str+suffix).map(car -> car!=" " ? car : "").reduce("", String::concat) );
//		System.out.println(Stream.of(prefix+str+suffix).filter(car -> car!=" ").reduce("", String::concat) );
	}

}
