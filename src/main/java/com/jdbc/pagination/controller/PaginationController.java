package com.jdbc.pagination.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.entities.PaginationResponse;
import com.jdbc.entities.Student;
import com.jdbc.pagination.service.Paginatiion;

/**
 * @author jumathew
 *
 */
@RestController
public class PaginationController {

	@Autowired
	Paginatiion pagination;
	
	@RequestMapping(value = "/jdbc/paginate-student", method = RequestMethod.GET)
	public PaginationResponse<Student>getStudentByPage(@RequestParam(required = true) HashMap<String, String> requestParams)
	{
		return pagination.getStudentByPaging(requestParams);
	}
	
}
