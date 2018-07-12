package com.jdbc.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jdbc.boot.JdbcBootstrapPagination1Application;

/**
 * @author jumathew
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=JdbcBootstrapPagination1Application.class)
public class JdbcBootstrapPagination1ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Ignore
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).toString().contains("Pagination");
	}
	
	@Test
	public void paginationEndPoint() {
		Map<String,String>reqParams=new HashMap<>();
 		reqParams.put("start", "0");
		reqParams.put("pageLength", "10");
		reqParams.put("orderBy", "5");
		reqParams.put("orderDirection", "asc");
		String body = this.restTemplate.getForObject("/jdbc/paginate-student?start={start}&pageLength={pageLength}&orderBy={orderBy}&orderDirection={orderDirection}", String.class,reqParams);
		assertThat(body).toString().contains("Pagination");
	}

}
