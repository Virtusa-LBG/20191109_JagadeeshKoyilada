package com.virtusa.codingtest;

import java.util.Scanner;

public class NumberConverter {

	static String word = "";
	static String[] ones = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static String[] tens = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	static String[] tens_multiple = new String[] { "twenty", "thirtee", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninty" };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			int number = 0;
			if (s.hasNext()) {
				try {
					number = s.nextInt();
				} catch (Exception e) {
					System.out.println("please enter valid number");
				}
			}
			if (number == 0) {
				System.out.println("please enter valid number");
			} else {
				System.out.println(convertNumbertoWord(String.valueOf(number), String.valueOf(number).length()));
			}
		} catch (Exception e) {
			System.out.println("Error while converting number to words" + e.getStackTrace());
		} finally {
			s.close();
		}
	}
	
	private static String convertNumbertoWord(String number, int length) throws Exception {
		String index;
		switch (length) {
		// code for handling single digit number
		case 1:
			word = word + " " + ones[Integer.valueOf(number)];
			break;
		// code for handling 10 digit number, if 10's digit was 1 then tens[] array
		// other wise tens_multiple[] array index based 10's digit number and change
		// number to 1's digit number
		case 2:
			index = "" + number.charAt(0);
			switch (Integer.valueOf(index)) {
			case 0:
				number = number.substring(1);
				convertNumbertoWord(number, number.length());
				break;
			case 1:
				index = "" + number.charAt(1);
				word = word + " " + tens[Integer.valueOf(index)];
				break;
			default:
				index = "" + number.charAt(0);
				word = word + " " + tens_multiple[Integer.valueOf(index)];
				number = number.substring(1);
				word = word + " " + convertNumbertoWord(number, number.length());
				break;
			}
		// code to handle 3 digit number
		case 3:
			index = "" + number.charAt(0);
			word = word + " " + ones[Integer.valueOf(index)] + " Hundered And";
			number = number.substring(1);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 4:
			word = word + " " + convertNumbertoWord(number.substring(0, 1), number.substring(0, 1).length())
					+ " thousand";
			number = number.substring(1);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 5:
			number = number.substring(0, 2);
			word = word + " " + convertNumbertoWord(number, number.length()) + " thousand";
			number = number.substring(2);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 6:
			number = number.substring(0, 3);
			word = word + " " + convertNumbertoWord(number, number.length()) + " thousand";
			number = number.substring(3);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 7:
			number = number.substring(0, 1);
			word = word + " " + convertNumbertoWord(number, number.length()) + " million";
			number = number.substring(1);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 8:
			number = number.substring(0, 2);
			word = word + " " + convertNumbertoWord(number, number.length()) + " million";
			number = number.substring(2);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		case 9:
			number = number.substring(0, 3);
			word = word + " " + convertNumbertoWord(number, number.length()) + " million";
			number = number.substring(3);
			word = word + " " + convertNumbertoWord(number, number.length());
			break;
		default:
			break;
		}
		return word;
	}

}
