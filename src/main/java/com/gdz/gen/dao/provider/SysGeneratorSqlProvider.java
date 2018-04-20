package com.gdz.gen.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * 代码生成器
 */
public class SysGeneratorSqlProvider {

	public String queryList(Map<String, Object> map) {
		SQL sql = new SQL();
		sql.SELECT("table_name");
		sql.SELECT("engine");
		sql.SELECT("table_comment");
		sql.SELECT("create_time");
		sql.FROM("information_schema.tables");
		sql.WHERE("table_schema = (select database())");
		if (map.get("tableName") != null) {
			sql.AND().WHERE("table_name like concat('%', #{tableName}, '%')");
		}
		sql.ORDER_BY("create_time desc");
		StringBuilder result = new StringBuilder(sql.toString());
		if (map.get("offset") != null && map.get("limit") != null) {
			result.append(" limit #{offset}, #{limit}");
		}
		return result.toString();
	}

	public String queryTotal(Map<String, Object> map) {
		SQL sql = new SQL();
		sql.SELECT("count(*)");
		sql.FROM("information_schema.tables");
		sql.WHERE("table_schema = (select database())");
		if (map.get("tableName") != null) {
			sql.AND().WHERE("table_name like concat('%', #{tableName}, '%')");
		}
		return sql.toString();
	}
}
