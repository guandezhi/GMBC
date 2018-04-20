package com.gdz.gen.entity;

import java.util.Date;

/**
 * 表属性
 */
public class TablesEntity {

	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 存储引擎
	 */
	private String engine;
	/**
	 * 表注释
	 */
	private String tableComment;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
