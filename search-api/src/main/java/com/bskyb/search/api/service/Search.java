package com.bskyb.search.api.service;

public interface Search {

	public void createIndex();
	
	public void IndexFiles();
	
	public void searchIndex(String searchString);
}