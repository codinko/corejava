package com.codinko.threads.threadimpl;

/**
 * 
 * To invoke the thread using new Thread(passing arguments)
 * 
 */
public class MyThread implements Runnable {

	public MyThread() {
		super();
	}

	public MyThread(String message) {
		System.out
				.println("Thread name is " + Thread.currentThread().getName());
		System.out.println("MyThread constructor called with message : "
				+ message);
		System.out.println();
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()
					+ " :going to sleep");
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName()
					+ " :running/ran");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
