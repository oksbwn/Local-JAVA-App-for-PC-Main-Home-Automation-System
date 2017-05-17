package com.oksbwn.News;

import com.oksbwn.ErrorHandling.handleExceptions;

public class addNewsDBase {
	public static void main(String[] args)
	{
		new addNewsDBase();
	}
public addNewsDBase()
    {
	addNewsToDB toDb=new addNewsToDB();
	try {
		toDb.readNews("http://feeds.feedburner.com/NDTV-Tech");
	} catch (Exception e) {	new handleExceptions(e);}
	try{
		toDb.readNews("http://feeds.feedburner.com/NDTV-LatestNews");
	} catch (Exception e) {	new handleExceptions(e);}
	try{toDb.readNews("http://feeds.hindustantimes.com/HT-HomePage-TopStories");
	} catch (Exception e) {	new handleExceptions(e);}
	try{toDb.readNews("http://syndication.indianexpress.com/rss/698/science---technology.xml");
	} catch (Exception e) {	new handleExceptions(e);}
	try{toDb.readNews("http://syndication.indianexpress.com/rss/latest-news.xml");
	} catch (Exception e) {	new handleExceptions(e);}
	try{toDb.readNews("http://timesofindia.feedsportal.com/c/33039/f/533965/index.rss");
	} catch (Exception e) {	new handleExceptions(e);}
    }
}
