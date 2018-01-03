package com.bskyb.search.api.util;

import java.util.Comparator;
import java.util.List;

import com.bskyb.search.api.ignore.ItemResource;

public class CompareChain implements Comparator<ItemResource> {
	
	private List<Comparator<ItemResource>> listComparators;

	public CompareChain(List<Comparator<ItemResource>> listComparators) {
		this.listComparators = listComparators;
	}

	@Override
	public int compare(ItemResource o1, ItemResource o2) {
		for (Comparator<ItemResource> comparator : listComparators) {
			System.out.println(o1 + " - " + o2 + " - " + comparator.getClass().getName());
			int result = comparator.compare(o1, o2);
			if(result != 0) {
				return result;
			}
		}
		return 0;
	}
	

}
