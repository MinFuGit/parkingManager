package com.buaa.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGuessDigitalGame {
		@Test
		public void should_return_4a0b_if_input_match_exactly(){
			GuessDigitalGame guess=new GuessDigitalGame("1234");
			String rs=guess.validate("1234");
			assertEquals("4a0b",rs);
		}
		
		@Test
		public void should_return_matches(){
			GuessDigitalGame guess=new GuessDigitalGame("1234");
			String[][] datas=new String[][]{
				new String[]{"",""},	
			};
		}
		
		
		
		@Test
		public void validateDataFormat(){
			GuessDigitalGame guess=new GuessDigitalGame("1234");
			String rs=guess.validate("1224");
			assertEquals(GuessDigitalGame.BAD_NUMBER,rs);
		}
		
		@Test
		public void validateDataFormat_num(){
			GuessDigitalGame guess=new GuessDigitalGame("1234");
			String rs=guess.validate("qwee");
			assertEquals(GuessDigitalGame.BAD_NUMBER,rs);
		}
}
