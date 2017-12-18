package com.bskyb.search.api.util;

import java.util.Comparator;

import com.bskyb.search.api.ignore.Temp;

public class CompareInt implements Comparator<Temp> {

	@Override
	public int compare(Temp o1, Temp o2) {
		
		if( o1.getSt() - o2.getSt() > 0 ) {
			return 1;
		} if(o1.getSt() - o2.getSt() < 0 ) {
			return -1;
		}
		
		return 0;
	}

}
