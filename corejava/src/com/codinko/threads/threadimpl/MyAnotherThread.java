package com.codinko.threads.threadimpl;

public class MyAnotherThread extends Thread {

	public MyAnotherThread() {
		super();
	}

	public MyAnotherThread(String message) {
		System.out
				.println("Thread name is " + Thread.currentThread().getName());
		System.out.println("MyAnotherThread constructor called with message : "
				+ message);
		System.out.println();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " :going to sleep for 1 second");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :running/ran");
		// new Thread("firstthread").notify();

	}
}
