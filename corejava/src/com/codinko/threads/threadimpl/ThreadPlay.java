package com.codinko.threads.threadimpl;

public class ThreadPlay {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		new Thread(t1, "firstthread").start();

		MyAnotherThread t2 = new MyAnotherThread();
		new Thread(t2, "secondthread").start();

	}
}
