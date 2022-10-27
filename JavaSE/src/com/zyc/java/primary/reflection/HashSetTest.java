package com.zyc.java.primary.reflection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {
	public static void main(String[] args) {
		Person person = new Person("tom",12);
		Person person2 = new Person("tom", 132);
		Person person3 = new Person("tom", 32);
		System.out.println(person.hashCode());
		System.out.println(person2.hashCode());
		
		Set<Person> set = new HashSet<Person>();
		Set<Person> terrSet = new TreeSet<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
		});
		
		
		set.add(person);
		set.add(person2);
		System.out.println(set);
		
		
		terrSet.add(person);
		terrSet.add(person2);
		terrSet.add(person3);
		System.out.println(terrSet);
	}

}
