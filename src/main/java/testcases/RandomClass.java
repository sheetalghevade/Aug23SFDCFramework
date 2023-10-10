package testcases;

import java.util.Random;

public class RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int upperbound = 100000000;
		int int_number = rand.nextInt();
		
		System.out.println(int_number);
		System.out.println("Random integer value from 0 to" + (upperbound-1) + " : " + int_number);
	}

}
