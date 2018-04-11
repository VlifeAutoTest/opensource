package com.jhopesoft.framework.utils;

import java.util.HashMap;
import java.util.Map;
import ognl.Ognl;
import ognl.OgnlException;
import com.jhopesoft.framework.dao.entity.dataobject.FDataobject;
import com.jhopesoft.framework.dao.entity.dataobject.FDataobjectfieldconstraint;
import com.jhopesoft.framework.exception.DataUpdateException;

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
public class DataobjectFieldConstraintUtils {

	public static void moduleFieldConstraintValid(FDataobject module, Object record) {
		if (module.getFDataobjectfieldconstraints().size() > 0) {
			Map<String, Object> errorMessage = new HashMap<String, Object>();
			int c = 0;
			for (FDataobjectfieldconstraint fc : module.getFDataobjectfieldconstraints()) {
				if (!fc.getIsdisable()) {
					try {
						if (((Boolean) Ognl.getValue(fc.getCexpression(), record)) == false) {
							c++;
							String k = fc.getErrormessagefield();
							if (errorMessage.containsKey(k))
								errorMessage.put(k, errorMessage.get(k).toString() + "<br/>" + fc.getErrormessage());
							else
								errorMessage.put(k, fc.getErrormessage());
						}
					} catch (OgnlException e) {

						c++;
						errorMessage.put("字段平衡表达式式错误", fc.getTitle() + "<br/><br/>表达式为:<br/>" + fc.getCexpression());
					}
				}
			}
			if (c != 0)
				throw new DataUpdateException(errorMessage);
		}
	}

}
