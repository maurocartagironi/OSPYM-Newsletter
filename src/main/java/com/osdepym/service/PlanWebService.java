package com.osdepym.service;

import java.util.List;
import com.osdepym.exception.CustomException;

public interface PlanWebService {

	public List<?> getSeccionesByPlan(String idPlan) throws CustomException;
	
}
