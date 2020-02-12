package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Newsletter;

@Repository
public class NewsletterDAOImpl implements NewsletterDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean exists(Newsletter newsletter) throws CustomException {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			String email = newsletter.getEmail();
			String queryString = "SELECT id FROM dbo.NEWSLETTER WHERE EMAIL = '" + email + "'";
			List<Newsletter> newsletterList = session.createNativeQuery(queryString, Newsletter.class).getResultList();
	        session.getTransaction().commit();
	        return newsletterList.size() > 0;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Newsletter get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Newsletter> getAll() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Newsletter newsletter) throws CustomException {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
		try {
	        session.save(newsletter);
	        session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} finally {
	        session.close();
		}
	}

	@Override
	public void update(Newsletter t) throws CustomException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Newsletter t) throws CustomException {
		// TODO Auto-generated method stub	
	}
}
