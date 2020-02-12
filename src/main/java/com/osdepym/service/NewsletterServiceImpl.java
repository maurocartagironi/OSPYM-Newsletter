package com.osdepym.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.dao.NewsletterDAO;
import com.osdepym.hibernate.entity.Newsletter;

@Service("NewsletterService")
public class NewsletterServiceImpl implements NewsletterService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private NewsletterDAO newsletterDAO;

	@Override
	public void save(Newsletter newsletter) throws CustomException {
		newsletterDAO.save(newsletter);		
	}
	
	public boolean exists(Newsletter newsletter) throws CustomException {
		return newsletterDAO.exists(newsletter);		
	}
}
