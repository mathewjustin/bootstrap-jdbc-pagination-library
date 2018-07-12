package com.jdbc.pagination.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.jdbc.entities.PaginationResponse;
import com.jdbc.entities.Student;
import com.jdbc.utils.ReflectionUtils;

/**
 * @author jumathew
 *
 */
@Service
public class Paginatiion {

	/*params are the pagination parameters sent by bootstrap data table*/
	public PaginationResponse<Student> getStudentByPaging(HashMap<String, String>params)
	{
		String queryString=ReflectionUtils.getPaginationQuery(params,Student.class);
		
		return null;
	}
	

	
	 
	
	
}
