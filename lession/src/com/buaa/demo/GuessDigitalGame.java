package com.buaa.demo;

import java.util.Random;

public class GuessDigitalGame {
		public static final int DATA_LENGTH=4;
		
		public static String getRadomDigit(){
			StringBuilder sb=new StringBuilder();
			Random rand=new Random();
			sb.append(Math.abs(rand.nextInt()%10));
			for(int i=1;i<DATA_LENGTH;i++){
				String s="";
				do{
					s=Math.abs(rand.nextInt(i*171)%10)+"";
				}while(sb.toString().contains(s));
				sb.append(s);
			}
			return sb.toString();
		}
		
		private String randomNumber="";
		public static final String BAD_NUMBER="数据不符合规范!";
		public GuessDigitalGame(String number){
			this.randomNumber=number;
		}
		public String validate(String num){
			String str=validateDataFormat(num);
			if(!str.equals("")){
				return str;
			}
			int a=0;
			int b=0;
			for(int i=0;i<DATA_LENGTH;i++){
			  for(int j=0;j<DATA_LENGTH;j++){
				  if(randomNumber.charAt(i)==num.charAt(j)){
					  if(i==j){
						  a++;
					  }else{
						  b++;
					  }
				  }
			  }
			}
			return a+"a"+b+"b";
		}
		public String validateDataFormat(String num){
			if(num==null){
				return BAD_NUMBER;
			}
			if(num.matches("\\d{"+DATA_LENGTH+"}")){
				for(int i=0;i<3;i++){
					for(int j=i+1;j<4;j++){
						if(num.charAt(i)==num.charAt(j)){
							return BAD_NUMBER;
						}
					}
				}
				return "";
			}else{
				return BAD_NUMBER;
			}
		}
}
