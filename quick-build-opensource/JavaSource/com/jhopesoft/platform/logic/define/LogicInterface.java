package com.jhopesoft.platform.logic.define;

import java.util.List;
import java.util.Map;

import com.jhopesoft.framework.core.dataobject.filter.UserNavigateFilter;
import com.jhopesoft.framework.core.dataobject.filter.UserParentFilter;

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
public interface LogicInterface<T> {

	public void beforeInsert(T inserted);

	public void afterInsert(T inserted);

	public void beforeUpdate(String type, T updatedObject, T oldObject);

	public void afterUpdate(String type, T updatedObject, T oldObject);

	public void beforeDelete(T deleted);

	public void afterDelete(T deleted);

	public Map<String, Object> getNewDefultValue(List<UserParentFilter> userParentFilters,
			List<UserNavigateFilter> navigateFilters);

}
