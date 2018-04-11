package com.jhopesoft.framework.core.dataobjectquery.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jhopesoft.framework.core.dataobject.BaseModule;
import com.jhopesoft.framework.core.dataobjectquery.sqlfield.SqlField;
/**
 * 
 * @author jiangfeng
 * 
 *         www.jhopesoft.com
 * 
 *         jfok1972@qq.com
 * 
 *         2017-06-01
 * 
 */
public class FieldGenerate {

	public static List<String> generateSelectFields(BaseModule baseModule, Set<SqlField> fields) {
		List<String> result = new ArrayList<String>();
		for (SqlField field : fields) {
			result.add(field.getSqlstatment() + " " + field.getScale());
		}
		return result;
	}

	public static void adjustScale(BaseModule baseModule, Set<SqlField> fields) {
		int count = 1001;
		for (SqlField field : fields) {

			if (field.getFieldname().length() > 30 || field.getFieldname().indexOf('.') != -1) {
				field.setScale("scale_" + count++);
			}
		}
	}

}
