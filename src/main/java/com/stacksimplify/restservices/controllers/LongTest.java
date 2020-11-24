package com.stacksimplify.restservices.controllers;

public class LongTest {

	public static void main(String[] args) {
		
		Long id1=12345L;
		Long id2=12345L;
		long id3=123456;
		long id4=123456;
		
		if (id1.equals(id2)) {
			System.out.println("E");
		}else {
			System.out.println("NE");
		}
		
		if (id3==id4) {
			System.out.println("E");
		}else {
			System.out.println("NE");
		}

	}

}
