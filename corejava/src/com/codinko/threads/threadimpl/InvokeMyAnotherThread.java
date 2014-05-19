package com.codinko.threads.threadimpl;

/**
 * MyAnotherThread extends Thread.
 */
public class InvokeMyAnotherThread {
	public static void main(String[] args) {
		/*
		 * This means if you call the start(). it does not mean the Thread will
		 * be run immediately. It is controlled by JVM.
		 */
		Thread t = new MyAnotherThread("hello thread how are you!");
		// t.start(); // problem here is that i cannot name this thread
		new Thread(t, "threadnamedharley").start();

		/*
		 * another way to name the thread. t.setName("threadnamedharley");
		 * t.start();
		 */

		/**
		 * How many threads now? Only Main and harley as you might have guessed.
		 */
	}
}
