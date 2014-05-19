Does

1. start two threads and work on one synchronized method to see which thread takes control
2. Play with synchronized, static synchronized, non synchronized etc ...

ToDo:

Play with  wait(), notify(), notifyAll()

--------------------
Service.java notes:
--------------------

The lock objects are different on the static method and non-static method. 
The static method uses the Class object as the lock (lock obj: MyClass.class),
 while the non-static method uses the instance object as the lock to which the 
 invocation of the method at that time is bound (lock obj: this).
 
	static synchronized void test() { 
		foo(); 
	}
  	
  	is equivalent to

	static void test() { 
		synchronized(MyClass.class) 
			{ 
				foo(); 
			}
		}


ie:

A synchronized static method is effectively equivalent to:

public static void foo() {
    synchronized (ClassName.class) {
        // Body
    }
}
In other words, it locks on the Class object associated with the class declaring the method.

//---------------------

Whereas,

	synchronized void test() { 
		foo(); 
	}

	equals

	void test() { 
		synchronized(this) { 
			foo(); 
		} 
	}
	
This means: While static methods lock on the class object of the class, 
non-static methods lock on the instance on which they're called 
(by default, synchronized(anyOtherLock) is also possible). 
Since they lock on different objects, they can run in "parallel". 

*/
