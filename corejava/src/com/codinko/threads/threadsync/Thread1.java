package com.codinko.threads.threadsync;

public class Thread1 extends Thread {

	@Override
	public void run() {
		
//------------------------------------------------------------------------------	
		
		//Service.staticSynchronizedCount();
		
//------------------------------------------------------------------------------		
		
		//Service.staticNonSynchronizedCount();

//------------------------------------------------------------------------------		

		
		/*Service instance = new Service();
			instance.nonStaticSynchronizedCount(instance); // Threads on two different objects/instances
		 */	
		
		/*Service instance = Service.getInstance();
			// pass the instance to see whether lock is kept on that instance on where the thread is running 
			instance.nonStaticSynchronizedCount(instance); // Threads on same object/instance
		 */		

//------------------------------------------------------------------------------		
		
		/*Service instance = new Service();
			instance.nonStaticNonSynchronizedCount(instance); // Threads on two different objects/instances
		*/		
		
		Service instance = Service.getInstance();
		// pass the instance to see whether lock is kept on that instance on where the thread is running 
		instance.nonStaticNonSynchronizedCount(instance); // Threads on same object/instance
	 
//------------------------------------------------------------------------------	
		
	}
}