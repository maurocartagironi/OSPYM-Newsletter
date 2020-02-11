package com.osdepym.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.dto.PlanItemDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.PlanItemDAO;
import com.osdepym.hibernate.entity.PlanItem;
import com.osdepym.util.SessionUtil;

@Service("PlanWebService")
public class PlanWebServiceImpl implements PlanWebService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private PlanItemDAO planItemDAO;

	public PlanItemDAO getPlanItemDAO() {
		return planItemDAO;
	}

	public void setPlanItemDAO(PlanItemDAO planItemDAO) {
		this.planItemDAO = planItemDAO;
	}

	@Override
	public List<?> getSeccionesByPlan(String idPlan) throws CustomException {
		List<?> secciones = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<PlanItem> items = planItemDAO.getItemsByPlan(idPlan);
			secciones = null;
			tx.commit();
			session.close();
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return secciones;
	}
}
