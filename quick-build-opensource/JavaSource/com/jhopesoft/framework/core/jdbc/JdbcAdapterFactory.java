package com.jhopesoft.framework.core.jdbc;

import com.jhopesoft.framework.core.jdbc.support.mysql.MySQL5SqlFunction;

public class JdbcAdapterFactory {

	public static MySQL5SqlFunction getJdbcAdapter(String jdbcType) {

		return MySQL5SqlFunction.getInstance();

	}

	public static MySQL5SqlFunction getJdbcAdapter(JdbcType jdbcType) {

		return MySQL5SqlFunction.getInstance();

	}

}
