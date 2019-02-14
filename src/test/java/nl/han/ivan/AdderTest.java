package nl.han.ivan;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdderTest {
	Adder adder;
	
	@BeforeEach
	public void setup() {
		adder = new Adder();
	}
	
	
	@Test
	public void testIfEmptyString() throws Exception {
		
		//Act
		int addedNumber = adder.add("");
		
		//Assert
		Assertions.assertEquals(0, addedNumber);
	}
	
	@Test
	public void testIfStringOne() throws Exception {
		//Act
		int addedNumber = adder.add("1");
		
		//Assert
		Assertions.assertEquals(1, addedNumber);
	}
	
	@Test
	public void testIfStringThree() throws Exception {
		int addedNumber = adder.add("1,2");
		
		Assertions.assertEquals(3, addedNumber);
	}

	@Test
	public void testIfStringCanHandleAlot() throws Exception{
		int addedNumber = adder.add("1,2,3,4,5");

		Assertions.assertEquals(15, addedNumber);
	}

	@Test
	public void testStringNewLineDeLimit() throws Exception {
		int addedNumber = adder.add("1\n2,3");
		
		Assertions.assertEquals(6, addedNumber);
	}


	@Test
	public void testStringNewDelimit() throws  Exception {
		int addedNumber = adder.add("//;\n1;2");

		Assertions.assertEquals(3, addedNumber);
	}

	@Test
	public void testStringNegatief(){

		Assertions.assertThrows(Exception.class, () -> adder.add("//;\n-1;-2"));
	}

	@Test
	public void testStringOver1000() throws Exception{
		int addedNumber = adder.add("2,1001");

		Assertions.assertEquals(2, addedNumber);
	}

	@Test
	public void testStringMultipleLengthDelimiters() throws Exception{
		int addedNumber = adder.add("//[***]\\n1***2***3");

		Assertions.assertEquals(6, addedNumber);
	}
}
