package com.jhopesoft.framework.core.dataobjectquery.filter;

import java.util.List;
import java.util.Set;

import com.jhopesoft.framework.core.dataobject.BaseModule;
import com.jhopesoft.framework.core.dataobject.ParentModule;
import com.jhopesoft.framework.core.dataobject.filter.UserDefineFilter;
import com.jhopesoft.framework.core.dataobjectquery.sqlfield.SqlField;
import com.jhopesoft.framework.core.dataobjectquery.sqlfield.SqlFieldUtils;
import com.jhopesoft.framework.dao.entity.dictionary.FDictionary;
import com.jhopesoft.framework.dao.entityinterface.ParentChildField;
import com.jhopesoft.framework.utils.OperateUtils;
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
public class FilterUtils {

	public static String getConditionSqlAndSetFilter(BaseModule baseModule, UserDefineFilter filter) {
		String result = null;
		if (filter.getProperty() != null) {
			JsonToConditionField conditionField = new JsonToConditionField();

			updateFieldNameToField(baseModule, conditionField, filter.isDictionaryName()
					? filter.getProperty().replaceAll(FDictionary.NAMEENDS, "") : filter.getProperty());
			Set<SqlField> fields = SqlFieldUtils.getSqlFieldFromParentChildField(baseModule, conditionField, null,
					true);

			SqlField sqlField = SqlFieldUtils.getSqlFieldFromFields(fields, filter.getProperty());
			if (sqlField == null) {

				sqlField = (SqlField) fields.toArray()[0];
			}
			String sqlstat = sqlField.getSqlstatment();
			if (filter.getCondition() != null)
				sqlstat = SqlFieldUtils.formatFieldWithCondition(filter.getCondition(), sqlstat);
			result = OperateUtils.getCondition(sqlstat, filter.getOperator(), filter.getValue());
		}
		if (filter.getChildren() != null && filter.getChildren().size() > 0) {
			String childCondition = getNextingConditionSql(baseModule, filter.getChildren());
			if (result == null)
				return childCondition;
			else
				return " ( " + result + " and " + childCondition + " ) ";
		}
		return result;
	}

	private static String getNextingConditionSql(BaseModule baseModule, List<UserDefineFilter> filters) {
		StringBuilder sb = new StringBuilder();
		for (UserDefineFilter filter : filters) {
			sb.append(" ( " + getConditionSqlAndSetFilter(baseModule, filter) + " ) ");
			if (filter != filters.get(filters.size() - 1))
				sb.append(" or ");
		}
		return " ( " + sb.toString() + " ) ";

	}

	static public void updateFieldNameToField(BaseModule baseModule, ParentChildField field, String fieldname) {
		if (fieldname.indexOf('.') == -1) {

			field.setFDataobjectfield(baseModule.getModule()._getModuleFieldByFieldName(fieldname));
		} else if (fieldname.indexOf(".with.") == -1) {

			int pos = fieldname.lastIndexOf('.');
			field.setFieldahead(fieldname.substring(0, pos));
			ParentModule pm = baseModule.getAllParents().get(field.getFieldahead());
			field.setFDataobjectfield(pm.getModule()._getModuleFieldByFieldName(fieldname.substring(pos + 1)));
		} else {

		}

		if (field.getFDataobjectfield()._isManyToOne() || field.getFDataobjectfield()._isOneToOne()) {
			field.setFieldahead((field.getFieldahead() == null ? "" : field.getFieldahead() + ".")
					+ field.getFDataobjectfield().getFieldtype());
			field.setFDataobjectfield(
					baseModule.getAllParents().get(field.getFieldahead()).getModule()._getPrimaryKeyField());
		}
	}

}
