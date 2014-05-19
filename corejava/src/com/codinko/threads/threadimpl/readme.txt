Does
	1. Difference between calling start() and run().
	2. One Notable difference in MyThread extends Thread or implements Runnable interface.
	3. How to name a thread in both the cases [a thread that extends Thread/ a thread that implements Runnable]
	4. Creating a Thread without creating a seperate class
	
Notes:
	1. When someclass implements Runnable , it does not BECOME a thread, it gives the Thread, something which is
 		runnable. So u have to do new Thread(..classname.).start() to start as new thread .
 	2. run() does not start a new thread. it is just like any other method. To start a new thread. u should use Start() 
