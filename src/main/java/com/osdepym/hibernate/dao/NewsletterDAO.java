package com.osdepym.hibernate.dao;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Newsletter;

public interface NewsletterDAO extends Dao<Newsletter> {
	public void save(Newsletter newsletter) throws CustomException;
	public boolean exists(Newsletter newsletter) throws CustomException;
}