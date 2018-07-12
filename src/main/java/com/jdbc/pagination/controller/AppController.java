package com.jdbc.pagination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jumathew
 *
 */
@Controller
public class AppController {

	@RequestMapping(value = "/")
	public String handleProductPage(ModelAndView model) {
		return "index";
	}
}
