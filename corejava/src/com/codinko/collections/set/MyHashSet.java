package com.codinko.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Define a set of objects and HashSet of objects and check how/when it uses 
 *  hashcode and equals */
/**
 * Aim: Set does not allow duplicates. So if you have a hashset of employee
 * objects with same name and id, then will the Set allow them to be added?
 * 
 * In case of HashSet, when you add or retrieve an element, it checks for
 * hashcode(), object references equivalence, and equals() method.
 * 
 */
public class MyHashSet {

	private static int counter = 1;

	private Set<String> addStringToHashSet() {
		Set<String> stringSet = new HashSet<String>();
		stringSet.add("obj1harley");
		stringSet.add("obj2nfs");
		stringSet.add("obj3java");
		stringSet.add("obj4php");
		stringSet.add("obj3java");
		return stringSet;
	}

	private Set<Employee> addEmployeeToHashSetType1() {
		Set<Employee> employeeSet = new HashSet<Employee>();
		employeeSet.add(new Employee(1, "obj1harley"));
		employeeSet.add(new Employee(1, "obj2nfs"));
		employeeSet.add(new Employee(1, "obj3java"));
		employeeSet.add(new Employee(1, "obj4php"));
		employeeSet.add(new Employee(1, "obj3java")); // different objects , but
														// as per
														// hashcode/equals impln
														// they are same objects
		return employeeSet;
	}

	private Set<Employee> addEmployeeToHashSetType2() {
		Set<Employee> employeeSet = new HashSet<Employee>();
		Employee obj1 = new Employee(1, "obj1harley");
		Employee obj2 = new Employee(1, "obj2nfs");
		Employee obj3 = new Employee(1, "obj3java");
		Employee obj4 = new Employee(1, "obj4php");
		Employee obj5 = obj3; // referring to same object

		employeeSet.add(obj1);
		employeeSet.add(obj2);
		employeeSet.add(obj3);
		employeeSet.add(obj4);
		employeeSet.add(obj5);
		return employeeSet;
	}

	public Set<String> getStringHashSet() {
		return addStringToHashSet();
	}

	public Set<Employee> getEmployeeHashSetType1() {
		return addEmployeeToHashSetType1();
	}

	public Set<Employee> getEmployeeHashSetType2() {
		return addEmployeeToHashSetType2();
	}

	public class Employee {

		// TODO document this error and erase it
		// private static int counter = 1;
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}

		int id;
		String name;

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			System.out.println("Hashcode (id:" + id + " || name:" + name
					+ ") is : " + result);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Employee other = (Employee) obj;
			System.out.println("Equals || Name: " + name + "|| OtherName: "
					+ other.name);
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private MyHashSet getOuterType() {
			return MyHashSet.this;
		}

	}

}
