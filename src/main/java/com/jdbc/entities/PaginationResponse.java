package com.jdbc.entities;

import java.util.List;

/**
 * @author jumathew
 *
 * @param <T>
 */
public class PaginationResponse<T> {

	private List<T>data;
	private int totalNumber;//100
	private int start;//displaying from 20
	private int size;//
	private int responseCode;
	private String responseMessage;
}
