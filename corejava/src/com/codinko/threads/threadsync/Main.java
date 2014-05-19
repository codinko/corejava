package com.codinko.threads.threadsync;

public class Main {
	public static void main(String[] args) {

		Thread t = new Thread1();
		new Thread(t, "threadnamedharley1").start();
		System.out.println("-------------------------------------");
		new Thread(new Thread2(), "threadnamedharley2").start();
	}
}
