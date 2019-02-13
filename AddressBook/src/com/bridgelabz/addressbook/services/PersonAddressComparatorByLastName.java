package com.bridgelabz.addressbook.services;

import java.util.Comparator;

import com.bridgelabz.addressbook.models.Person;

@SuppressWarnings("hiding")
public class PersonAddressComparatorByLastName<Object> implements Comparator<Object> {
	@Override
	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Person) || !(obj2 instanceof Person))
			throw new IllegalArgumentException("Can't compare non-person objects...!");
			else {

				Person p1 = (Person)obj1;
				Person p2 = (Person)obj2;
				String lastName1 = p1.getLastName();
				String lastName2 = p2.getLastName();
				int value =  lastName1.compareTo(lastName2);
				if(value == 0)//both are having the same lastnames
					return p1.getId() - p2.getId();
				else
					return value;
			}
	}
}
