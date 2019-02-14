package nl.han.ivan;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Adder {

	public int add(String numbers) throws Exception{
		if (numbers.equals("") || numbers.isEmpty()) {
			return 0;
		}


		int uitvoer = 0;
		List<String> negatiefGetallen = new ArrayList<>();
		if (numbers.contains(",") || numbers.contains("\n") || numbers.contains("//") || numbers.contains(";")) {

			String[] addNumbers = numbers.split("//|,|\n|;");
			for (int i = 0; i < addNumbers.length; i++) {
				addNumbers[i].replaceAll("[\\s|\\u00A0]+", "");
				if(addNumbers[i].equals("") || addNumbers[i].isEmpty() || Integer.parseInt(addNumbers[i]) > 1000){
					//do nothing
				} else if(Integer.parseInt(addNumbers[i]) < 0){
					negatiefGetallen.add(addNumbers[i]);
				} else {
					uitvoer += Integer.parseInt(addNumbers[i]);
				}
			}
			if(negatiefGetallen.size() > 0){
				throw new Exception("Negatieve waarde niet toegestaan:" + Arrays.toString(negatiefGetallen.toArray()));
			} else {
				return uitvoer;
			}
		} else {
			return Integer.parseInt(numbers);
		}
	}
}
