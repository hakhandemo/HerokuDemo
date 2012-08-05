package com.hysoft.demo.controllers;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.*;

import com.hysoft.demo.services.*;

/**
 * Handles requests for the application home page.
 */
@Controller

public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	  public String list(Model model) {
	    logger.info("Accessing Twitter");
	    //model.addAttribute("tramps",tramps);
	    model.addAttribute("tweets",twitterService.getTweets());
	    return "details"; 
	    
	  }
}
