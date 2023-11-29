package com.training.org;

class Singleton {
	static boolean onlyOne = false;
	static Singleton s1;
	int price = 100;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (onlyOne == false) {
			onlyOne = true;
			s1 = new Singleton();
			return s1;
		} else {
			System.out.println("You can not create a second object");
			return null;
		}
	}
}

public class SingletonTest {
	public static void main(String args[]) {

		// Singleton s1 = new Singleton( ); raises error as Singleton( ) is private
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1.price);

		Singleton s2 = Singleton.getInstance(); // s2 not created and prints else part
	}
}

/*
 * Singleton Pattern says that
 * just"define a class that has only one instance and provides a global point of access to it"
 * . In other words, a class must ensure that only single instance should be
 * created and single object can be used by all other classes. There are two
 * forms of singleton design pattern Early Instantiation: creation of instance
 * at load time. Lazy Instantiation: creation of instance when required. To
 * create the singleton class, we need to have static member of class, private
 * constructor and static factory method.
 * 
 * Static member: It gets memory only once because of static, itcontains the
 * instance of the Singleton class. Private constructor: It will prevent to
 * instantiate the Singleton class from outside the class. Static factory
 * method: This provides the global point of access to the Singleton object and
 * returns the instance to the caller. Understanding early Instantiation of
 * Singleton Pattern In such case, we create the instance of the class at the
 * time of declaring the static data member, so instance of the class is created
 * at the time of classloading.
 */