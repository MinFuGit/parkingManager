package com.buaa.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGuessDigitalGameDemo {
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
				new String[]{"4a0b","1234"},	
				new String[]{"3a0b","1235"},	
				new String[]{"2a0b","1278"},	
				new String[]{"1a0b","1987"},	
				new String[]{"0a0b","6789"},	
				
				new String[]{"0a4b","2341"},	
				new String[]{"0a3b","0341"},	
				new String[]{"0a2b","2367"},	
				new String[]{"0a1b","5167"},	
			};
			for(String[] data:datas){
				assertEquals(data[0],guess.validate(data[1]));
			}
		}
		
		@Test
		public void test_generator_random_digit(){
			for(int i=0;i<10;i++){
				GuessDigitalGame guess=new GuessDigitalGame("1234");
				String data=GuessDigitalGame.getRadomDigit();
				System.out.println(data);
				assertEquals("", guess.validateDataFormat(data));
			}
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
