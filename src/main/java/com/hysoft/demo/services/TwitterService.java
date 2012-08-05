package com.hysoft.demo.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.text.DateFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

	private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
	
	public HashMap getTweets()
	{
		 HashMap map = new HashMap();
		 Twitter twitter = new TwitterFactory().getInstance();
	        try {
	            List<Status> statuses;
	            
	           
	                statuses = twitter.getUserTimeline("iamsrk");
	           
	            logger.info("Showing @" + "iamsrk" + "'s user timeline.");
	            for (Status status : statuses) {
	            	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
	        		String formattedDate = dateFormat.format(status.getCreatedAt()); 
	        		
	            	logger.info("@" +formattedDate + " - " + status.getText());
	            	map.put(formattedDate, status.getText());
	            	
	            }
	            return map;
	        }
	         catch (TwitterException te) {
	            te.printStackTrace();
	            logger.info("Failed to get timeline: " + te.getMessage());
	            return map;
	        }
	}
}
