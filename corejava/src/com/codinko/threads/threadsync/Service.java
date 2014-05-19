package com.codinko.threads.threadsync;

public class Service {

	private static int staticCount = 0;
	private int nonStaticCount = 0;

	private static Service instance = new Service();

	public static Service getInstance() {
		return instance;
	}

//@formatter:off	
	/**
	 * OUTPUT of staticSynchronizedCount :
	 * 
Thread entered: threadnamedharley1
threadnamedharley1: count is 1
threadnamedharley1 holding Lock of Service class? : true
threadnamedharley1: completed executing this method
Thread entered: threadnamedharley2
threadnamedharley2: count is 2
threadnamedharley2 holding Lock of Service class? : true
threadnamedharley2: completed executing this method
	 */
	//@formatter:on	
	public static synchronized void staticSynchronizedCount() {
		System.out.println("Thread entered: "
				+ Thread.currentThread().getName());
		staticCount++;
		try {
			/*
			 * sleeping the thread to see if some other thread access the
			 * ongoing thread just after count incremented, and before executing
			 * completely.
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": count is "
				+ staticCount);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ " holding Lock of Service class? : "
				+ Thread.holdsLock(Service.class));
		System.out.println(Thread.currentThread().getName()
				+ ": completed executing this method");

	}

	//@formatter:off
/**
 * OUTPUT of staticNonSynchronizedCount :
 * 
Thread entered: threadnamedharley1
Thread entered: threadnamedharley2
threadnamedharley2: count is 2
threadnamedharley1: count is 2
threadnamedharley1 holding Lock of Service class? : false
threadnamedharley1: completed executing this method
threadnamedharley2 holding Lock of Service class? : false
threadnamedharley2: completed executing this method

next run:

Thread entered: threadnamedharley1
Thread entered: threadnamedharley2
threadnamedharley1: count is 2
threadnamedharley2: count is 2
threadnamedharley2 holding Lock of Service class? : false
threadnamedharley2: completed executing this method
threadnamedharley1 holding Lock of Service class? : false
threadnamedharley1: completed executing this method

--the above two results toggles on subsequent runs.

 */
	//@formatter:on
	public static void staticNonSynchronizedCount() {
		System.out.println("Thread entered: "
				+ Thread.currentThread().getName());
		staticCount++;
		try {
			/*
			 * sleeping the thread to see if some other thread access the
			 * ongoing thread just after count incremented, and before executing
			 * completely.
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": count is "
				+ staticCount);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ " holding Lock of Service class? : "
				+ Thread.holdsLock(Service.class));
		System.out.println(Thread.currentThread().getName()
				+ ": completed executing this method");

	}

	//@formatter:off	
	/**
	 * OUTPUT of nonStaticSynchronizedCount :
	 * 
	 * 
	 * Case1: Calling this method from two different objects/instances of Service class. 
	 *       So the two different nonStaticSynchronizedCount() methods are called. 
	 *       Hence Synchronization does not come into picture. It is irrelevant here.
	 *       Because method is synchronized, the lock is kept on the object, but doesnt help as 2 locks on 2 diff objects,
	 *       and we have 1 thread on each object. There is no sharing. So try with same Service instance.
	 *
Thread entered: threadnamedharley1
Thread entered: threadnamedharley2
threadnamedharley1: count is 1
threadnamedharley2: count is 1
threadnamedharley1 holding Lock of Service instance? : true
threadnamedharley1: completed executing this method
threadnamedharley2 holding Lock of Service instance? : true
threadnamedharley2: completed executing this methodd

	 * Case2: Calling this method from same objects/instance of Service class. 
	 *       So the Lock is on the one same instance object . Hence the two threads execute the same method. 
	 *       we need synchronized.
	 *       
Thread entered: threadnamedharley1
threadnamedharley1: count is 1
threadnamedharley1 holding Lock of Service instance? : true
threadnamedharley1: completed executing this method
Thread entered: threadnamedharley2
threadnamedharley2: count is 2
threadnamedharley2 holding Lock of Service instance? : true
threadnamedharley2: completed executing this method

	 */
	//@formatter:on
	public synchronized void nonStaticSynchronizedCount(Service instance) {
		System.out.println("Thread entered: "
				+ Thread.currentThread().getName());
		nonStaticCount++;
		try {
			/*
			 * sleeping the thread to see if some other thread access the
			 * ongoing thread just after count incremented, and before executing
			 * completely.
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": count is "
				+ nonStaticCount);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ " holding Lock of Service instance? : "
				+ Thread.holdsLock(instance));
		System.out.println(Thread.currentThread().getName()
				+ ": completed executing this method");

	}

	//@formatter:off	
	/**
	 * OUTPUT of nonStaticNonSynchronizedCount :
	 * 
	 * Case1: Calling this method from two different objects/instances of Service class. 
	 * Case2: Calling this method from same single instance of Service class.
	 * 
	 * Case1:
Thread entered: threadnamedharley1
Thread entered: threadnamedharley2
threadnamedharley2: count is 1
threadnamedharley1: count is 1
threadnamedharley1 holding Lock of Service instance? : false
threadnamedharley1: completed executing this method
threadnamedharley2 holding Lock of Service instance? : false
threadnamedharley2: completed executing this method

	* Case2:

Thread entered: threadnamedharley1
Thread entered: threadnamedharley2
threadnamedharley1: count is 2
threadnamedharley2: count is 2
threadnamedharley2 holding Lock of Service instance? : false
threadnamedharley2: completed executing this method
threadnamedharley1 holding Lock of Service instance? : false
threadnamedharley1: completed executing this method


	 */
	//@formatter:on
	public void nonStaticNonSynchronizedCount(Service instance) {
		System.out.println("Thread entered: "
				+ Thread.currentThread().getName());
		nonStaticCount++;
		try {
			/*
			 * sleeping the thread to see if some other thread access the
			 * ongoing thread just after count incremented, and before executing
			 * completely.
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": count is "
				+ nonStaticCount);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ " holding Lock of Service instance? : "
				+ Thread.holdsLock(instance));
		System.out.println(Thread.currentThread().getName()
				+ ": completed executing this method");

	}
}
