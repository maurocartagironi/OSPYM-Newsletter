package com.osdepym.service;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Newsletter;

public interface NewsletterService {
	public void save(Newsletter newsletter) throws CustomException;
	public boolean exists(Newsletter newsletter) throws CustomException;
}
