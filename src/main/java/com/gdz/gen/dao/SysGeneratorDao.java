package com.gdz.gen.dao;

import com.gdz.gen.dao.provider.SysGeneratorSqlProvider;
import com.gdz.gen.entity.ColumnEntity;
import com.gdz.gen.entity.TablesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 */
@Mapper
@Component(value = "sysGeneratorDao")
public interface SysGeneratorDao {

	@SelectProvider(type = SysGeneratorSqlProvider.class, method = "queryList")
	List<TablesEntity> queryList(Map<String, Object> map);

	@SelectProvider(type = SysGeneratorSqlProvider.class, method = "queryTotal")
	int queryTotal(Map<String, Object> map);

	@Select({ "select table_name, engine, table_comment, create_time ", " from information_schema.tables ",
			" where table_schema = (select database()) and table_name = #{tableName}" })
	TablesEntity queryTable(String tableName);

	@Select({ "select column_name, data_type, column_comment comments, column_key, extra from information_schema.columns ",
			" where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position" })
	List<ColumnEntity> queryColumns(String tableName);
}
