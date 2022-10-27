package JavaStreams;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamsExample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> cars=new ArrayList<String>();
		cars.add("Mclaren");
		cars.add("BMW");
		cars.add("Audi");
		cars.add("Ferrari");
		cars.add("Hummer");
		cars.add("Renault");
		cars.stream().forEach(car->System.out.println(car));

	}

}
