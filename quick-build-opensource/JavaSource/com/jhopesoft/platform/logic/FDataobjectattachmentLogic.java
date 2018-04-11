package com.jhopesoft.platform.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jhopesoft.framework.critical.Local;
import com.jhopesoft.framework.dao.entity.attachment.FDataobjectattachment;
import com.jhopesoft.platform.logic.define.AbstractBaseLogic;
import com.jhopesoft.platform.service.AttachmentService;

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
public class FDataobjectattachmentLogic extends AbstractBaseLogic<FDataobjectattachment> {

	@Autowired
	private AttachmentService attachmentService;

	@Override
	public void beforeDelete(FDataobjectattachment bean) {

		if (bean.getFDataobjectattachmentfile() != null) {
			Local.getDao().delete(bean.getFDataobjectattachmentfile());
		}

		if (bean.getFDataobjectattachmentpdffile() != null) {
			Local.getDao().delete(bean.getFDataobjectattachmentpdffile());
		}

		if (bean.getLocalpathname() != null) {
			attachmentService.deleteFile(bean);
		}

	}

}
