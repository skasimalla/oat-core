package com.atomicitysystems.DAO;

public class DBMapping {

    private String category;
    private String columnName;
    private String mapping;
    
    
	public DBMapping(String category, String columnName, String mapping) {
		this.category = category;
		this.columnName = columnName;
		this.mapping = mapping;
	}

	public DBMapping(String columnName, String mapping) {
		this.columnName = columnName;
		this.mapping = mapping;
	}

	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getMapping() {
		return mapping;
	}
	public void setMapping(String mapping) {
		this.mapping = mapping;
	}
    

 
}
