package com.buaa.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TempTest {

	@Test
	public void testTemp(){
		int a=-102;
		Math.abs(a);
		assertEquals(2,a%10);
	}
}
