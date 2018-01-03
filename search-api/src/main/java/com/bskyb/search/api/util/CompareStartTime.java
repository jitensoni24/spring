package com.bskyb.search.api.util;

import java.util.Comparator;

import com.bskyb.search.api.ignore.ItemResource;

public class CompareStartTime implements Comparator<ItemResource> {

	@Override
	public int compare(ItemResource o1, ItemResource o2) {
		return o1.getSt().compareTo(o2.getSt());
	}

}
