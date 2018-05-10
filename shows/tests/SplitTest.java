package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SplitTest {

	@Test
	void test() {
		String test = "this text is a test for split method";
		String[] check = test.split(" ");
		
		
		assertEquals("test", check[4]);
	}

}
