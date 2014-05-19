package com.codinko.collections.set;

import java.util.Iterator;
import java.util.Set;

import com.codinko.collections.set.MyHashSet.Employee;

public class MyHashSetMain {

	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();

		Set<String> stringSet = myHashSet.getStringHashSet();
		Iterator<String> strIterator = stringSet.iterator();
		while (strIterator.hasNext()) {
			String string = (String) strIterator.next();
			System.out.println(string);
		}
		System.out.println("***************************************");

		Set<Employee> employeeSet = myHashSet.getEmployeeHashSetType1();
		Iterator<Employee> empIterator = employeeSet.iterator();
		while (empIterator.hasNext()) {
			Employee emp = (Employee) empIterator.next();
			System.out.println(emp);
		}
		System.out.println("***************************************");

		Set<Employee> employeeSet2 = myHashSet.getEmployeeHashSetType2();
		Iterator<Employee> empIterator2 = employeeSet2.iterator();
		while (empIterator2.hasNext()) {
			Employee emp = (Employee) empIterator2.next();
			System.out.println(emp);
		}

	}

}
