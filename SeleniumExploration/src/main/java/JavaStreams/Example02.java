package JavaStreams;

import java.util.ArrayList;
import java.util.List;

public class Example02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<String> cars=new ArrayList<String>();
		cars.add("Mclaren");
		cars.add("BMW");
		cars.add("Audi");
		cars.add("Ferrari");
		cars.add("Hummer");
		cars.add("Renault");
		cars.stream().filter(car->
		{
			return car.equals("Mclaren");
			
		}).forEach(car->System.out.println(car));

	}

}
