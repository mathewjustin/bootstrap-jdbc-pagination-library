package com.jdbc.custom.annotations;

/**
 * @author jumathew
 *
 */
public class RowData {

	private String name;
	private int rowPosition;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRowPosition() {
		return rowPosition;
	}
	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}
}
