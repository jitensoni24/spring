package com.bskyb.search.api.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bskyb.search.api.ignore.Temp;
import com.github.javafaker.Faker;

public class GenericUtil {
	
	public static final Faker fake = Faker.instance();

	public static void main(String[] args) {
		
		Temp t;

		List<Temp> list = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++ ) {
			t = new Temp();
			t.setNo( fake.number().numberBetween(1, 20) );
			t.setSt( fake.number().numberBetween(20, 30) );
			t.setName( " test - " + fake.number().numberBetween(1, 5) );
			
			list.add(t);
		}
		
		Collections.sort( list, new CompareInt() );
		
		list.forEach( l -> System.out.println(l) );
	}
}
