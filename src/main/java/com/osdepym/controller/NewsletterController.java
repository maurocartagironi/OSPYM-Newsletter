package com.osdepym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.NewsletterForm;
import com.osdepym.hibernate.entity.Newsletter;
import com.osdepym.response.Response;
import com.osdepym.service.NewsletterService;

@Controller
public class NewsletterController {
	@Autowired
	@Qualifier("NewsletterService")
	private NewsletterService service;
	
	@RequestMapping(value = "/saveEmail")
	public @ResponseBody Response saveEmail(@RequestBody NewsletterForm newsletterForm) throws CustomException {
		Response response = new Response("ERROR", ErrorMessages.UNKNOWN_ERROR, null);
		try {
			Newsletter newsletter = new Newsletter();
			newsletter.setEmail(newsletterForm.getEmail());
			newsletter.setName(newsletterForm.getName());
			System.out.println(newsletter.getEmail());
			if(!service.exists(newsletter)) {
				service.save(newsletter);
				response = new Response("SUCCESS", null, null);
			} else {
				response = new Response("ERROR", ErrorMessages.NEWSLETTER_DUPLICATE_ERROR, null);
			}	
		} catch (Exception e) {
			response = new Response("ERROR", ErrorMessages.UNKNOWN_ERROR, e.getMessage());
		}
		return response;
	}
}
