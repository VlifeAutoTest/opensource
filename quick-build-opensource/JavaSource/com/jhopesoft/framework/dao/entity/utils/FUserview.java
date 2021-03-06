package com.jhopesoft.framework.dao.entity.utils;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

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

@SuppressWarnings("serial")
@Entity
@DynamicUpdate
@Table(name = "f_userview", uniqueConstraints = { @UniqueConstraint(columnNames = "title"),
		@UniqueConstraint(columnNames = "viewname") })
public class FUserview implements java.io.Serializable {

	private String viewid;
	private String title;
	private String viewgroup;
	private String viewname;
	private String sqlstatment;
	private boolean iscreated;
	private String remark;
	private String creater;
	private Date createdate;
	private String lastmodifier;
	private Date lastmodifydate;

	public FUserview() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Column(name = "viewid", unique = true, nullable = false, length = 40)
	public String getViewid() {
		return this.viewid;
	}

	public void setViewid(String viewid) {
		this.viewid = viewid;
	}

	@Column(name = "title", unique = true, nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "viewgroup", nullable = false, length = 20)
	public String getViewgroup() {
		return this.viewgroup;
	}

	public void setViewgroup(String viewgroup) {
		this.viewgroup = viewgroup;
	}

	@Column(name = "viewname", unique = true, nullable = false, length = 30)
	public String getViewname() {
		return this.viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

	@Column(name = "sqlstatment", length = 2000)
	public String getSqlstatment() {
		return this.sqlstatment;
	}

	public void setSqlstatment(String sqlstatment) {
		this.sqlstatment = sqlstatment;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "creater", nullable = false, length = 40)
	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdate", nullable = false, length = 19)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "lastmodifier", length = 40)
	public String getLastmodifier() {
		return this.lastmodifier;
	}

	public void setLastmodifier(String lastmodifier) {
		this.lastmodifier = lastmodifier;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodifydate", length = 19)
	public Date getLastmodifydate() {
		return this.lastmodifydate;
	}

	public void setLastmodifydate(Date lastmodifydate) {
		this.lastmodifydate = lastmodifydate;
	}

	public boolean isIscreated() {
		return iscreated;
	}

	public void setIscreated(boolean iscreated) {
		this.iscreated = iscreated;
	}

}
