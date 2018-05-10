package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import model.User;

class UserTest {

	@Test
	void test() {
		User u = new User();
		u.setName("M");
		assertEquals("M", u.getName());
	}

}
