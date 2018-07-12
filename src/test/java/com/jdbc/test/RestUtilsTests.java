package com.jdbc.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jdbc.entities.Student;
import com.jdbc.utils.ReflectionUtils;

/**
 * @author jumathew
 *
 */
public class RestUtilsTests {

	
	@Test
	public void testPaginationQuery()
	{
		assertEquals("SELECT student_id,student_name,student_dept,student_dept_loc,created_on,created_by FROM Student_tbl LIMIT 10 OFFSET 0", ReflectionUtils.getPaginationQuery(getDummyReqParamsWithoutOrderAndDirection(), Student.class)); 
	}
	

//	SELECT expressions
//	FROM tables
//	[WHERE conditions]
//	[ORDER BY expression [ ASC | DESC ]]
//	LIMIT number_rows [ OFFSET offset_value ];
	@Test
	public void testPaginationQueryWithSort()
	{
		assertEquals("SELECT student_id,student_name,student_dept,student_dept_loc,created_on,created_by FROM "
				+ "Student_tbl "
				+ "ORDER BY created_by "
				+ "LIMIT 10 OFFSET 0", ReflectionUtils.getPaginationQuery(getDummyReqParamsWithOrderAndDirection(), Student.class)); 
	}
	

	private Map<String, String>getDummyReqParamsWithoutOrderAndDirection()
	{
		Map<String,String>reqParams=new HashMap<>();
 		reqParams.put("start", "0");
		reqParams.put("pageLength", "10");
		return reqParams;
	}
	private Map<String, String>getDummyReqParamsWithOrderAndDirection()
	{
		Map<String,String>reqParams=new HashMap<>();
 		reqParams.put("start", "0");
		reqParams.put("pageLength", "10");
		reqParams.put("orderBy", "5");
		reqParams.put("orderDirection", "asc");
		return reqParams;
	}
	
	
}
