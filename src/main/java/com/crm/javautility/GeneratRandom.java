package com.crm.javautility;

import java.util.Random;

public class GeneratRandom {

	public static int random() {
	Random r = new Random();
	int value = r.nextInt(1000);
	return value;
}
}
