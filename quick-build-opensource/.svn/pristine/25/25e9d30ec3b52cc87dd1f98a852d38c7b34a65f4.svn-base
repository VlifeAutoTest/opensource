package com.jhopesoft.platform.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.jhopesoft.framework.core.dataobject.filter.UserNavigateFilter;
import com.jhopesoft.framework.core.dataobject.filter.UserParentFilter;
import com.jhopesoft.framework.dao.entity.system.FUser;
import com.jhopesoft.framework.utils.MD5;
import com.jhopesoft.platform.logic.define.AbstractBaseLogic;

@Component

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
public class FUserLogic extends AbstractBaseLogic<FUser> {

	@Override
	public void beforeInsert(FUser bean) {
		bean.setSalt(UUID.randomUUID().toString());
		bean.setPassword(MD5.MD5Encode(bean.getPassword() + bean.getSalt()));
	}

	@Override
	public Map<String, Object> getNewDefultValue(List<UserParentFilter> userParentFilters,
			List<UserNavigateFilter> navigateFilters) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("password", "123456");
		return map;
	}

}
