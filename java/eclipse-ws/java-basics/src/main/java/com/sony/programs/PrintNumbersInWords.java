package com.sony.programs;

public class PrintNumbersInWords {

	public static void main(String[] args) {
		// 1 to 20 --> single words
		// 10 to 90 --> (multiples of 10) single words
		// hundred, thousand, lakh, crore
		// 27,34,0,56
		
		String[] ar1 = {"", "one", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
		String[] ar2 = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] ar3 = {"", "hundred", "thousand", "lakh", "crore"};
		
		int input = 122734056;
		// [12,27,34,7,56]
		int[] stack = new int[5];
		int i;
		for( i=0; input>0; i++) {
			if(i==1) {
				stack[i]=input%10;
				input /=10;
			}
			else {
				stack[i] = input%100;
				input/=100;
			}
		}
		i--;
		String output = "";
		
		while(i>=0) {
			
			int n = stack[i];
			if(n==0) {
				i--;
				continue;
			}
			if(n<20) {
				output += ar1[n] + " " + ar3[i] + " ";
			}
			else {
				int p1 = n/10, p2=n%10;
				output += ar2[p1] + " " + ar1[p2] + " "+ ar3[i]+ " ";
			}
			
			
			i--;
		}
		System.out.println(output);
		
	}
}
