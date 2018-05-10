package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.Movies;

class ShowName {

	@Test
	void test() {
		Movies movie = new Movies("AVG", "", "", null, "", "");
		assertEquals("AVG", movie.getName());
		
		
	}

}
