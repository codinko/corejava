package com.codinko.threads.threadimpl;

/**
 * Difference between calling start() and run().
 * Calling run() is just calling another method and runs inside the existing thread (here , main).
 * Calling start() is to make something [logic inside run()] to run in a new thread. JVM then calls run()
 * 
 * API definition: start() method: Causes the thread to begin execution;
 * 				   the Java Virtual Machine calls the run method of this thread.
 */
/**
 * 
 * @author Harley
 * 
 *         MyThread implements Runnable interface
 */
public class InvokeMyThread {
	public static void main(String[] args) {
		/**
		 * There is one notable difference in MyThread extends Thread or
		 * implements Runnable interface. - If MyThread extends Thread, then you
		 * can do new MyThread().start(); - If MyThread implements Runnable,
		 * then there is no start(), so you have to create a new
		 * Thread(r).start();
		 */
		Runnable r = new MyThread("hello thread how are you!");
		new Thread(r, "threadnamedharley").start();
	}
}
