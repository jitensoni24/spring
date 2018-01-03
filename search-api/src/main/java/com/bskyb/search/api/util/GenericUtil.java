package com.bskyb.search.api.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.bskyb.search.api.ignore.ItemResource;
import com.github.javafaker.Faker;

public class GenericUtil {
	
	public static final Faker fake = Faker.instance();
	
	public static final int graceEndTime = 300;

	public static void main(String[] args) {
		
		ItemResource t;

		List<ItemResource> list = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++ ) {
			t = new ItemResource();
			t.setNo( fake.number().numberBetween(1, 10) );
			t.setSt( fake.number().numberBetween(1, 5) );
			t.setEndTime( 1513691195);
			t.setName( " t-" + i );
			
			
			list.add(t);
		}
		
		Collections.sort( list, new CompareChain(Arrays.asList(new CompareStartTime(), new CompareNo())));
		
		ItemResource finalItem = null;
		
		for (int i=0; i<list.size(); i++) {
			
			if(list.get(i).getEndTime() >  (int)Instant.now().getEpochSecond() + graceEndTime) {
				finalItem = list.get(i);
				break;
			}
		}
		if(finalItem != null) {
			System.out.println("here - " + (int)Instant.now().getEpochSecond());
			System.out.println(finalItem);
			System.out.println("here");
		}
		
		/*Temp least = null;
		
		for (Temp t1 : list) {
			if(least == null) {
				least = t1;
			} else {
				if(least.getNo() > t1.getNo()) {
					least = t1;
				}
			}
		}
		
		System.out.println(least);

		System.out.println();*/
		
		list.forEach( l -> System.out.println(l) );

		String eid = "Ef64-5e";
		
		Integer valueOf = Integer.decode("#" + eid.split("-")[0].substring(1));
		System.out.println(valueOf);
		Integer valueOf2 = Integer.decode("#" + eid.split("-")[1]);
		System.out.println(valueOf2);

		System.out.println("E"+Integer.toHexString(4002) + "-" + Integer.toHexString(675));
		
		
		
	}
}
