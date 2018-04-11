package com.jhopesoft.framework.dao.entity.datamining;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.jhopesoft.framework.dao.entity.dataobject.FDataobject;
import com.jhopesoft.framework.dao.entity.system.FUser;

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
@Table(name = "f_dataminingscheme")
public class FDataminingscheme implements java.io.Serializable {

	private String schemeid;
	private FDatamininggroup FDatamininggroup;
	private FDataobject FDataobject;
	private FUser FUser;
	private Integer orderno;
	private String iconcls;
	private String title;
	private String subtitle;
	private Integer maxcolumns;
	private Boolean isshare;
	private Boolean isshareowner;
	private String othersetting;
	private String remark;
	private String creater;
	private Date createdate;
	private String lastmodifier;
	private Date lastmodifydate;
	private Set<FDataminingselectfield> FDataminingselectfields = new HashSet<FDataminingselectfield>(0);
	private Set<FDataminingcolumngroup> FDataminingcolumngroups = new HashSet<FDataminingcolumngroup>(0);

	public FDataminingscheme() {
	}

	public FDataminingscheme(String schemeid, FDatamininggroup FDatamininggroup, FDataobject FDataobject, FUser FUser,
			String creater, Date createdate) {
		this.schemeid = schemeid;
		this.FDatamininggroup = FDatamininggroup;
		this.FDataobject = FDataobject;
		this.FUser = FUser;
		this.creater = creater;
		this.createdate = createdate;
	}

	public FDataminingscheme(String schemeid, FDatamininggroup FDatamininggroup, FDataobject FDataobject, FUser FUser,
			Integer orderno, String iconcls, String title, String subtitle, Integer maxcolumns, Boolean isshare,
			Boolean isshareowner, String othersetting, String remark, String creater, Date createdate,
			String lastmodifier, Date lastmodifydate, Set<FDataminingselectfield> FDataminingselectfields,
			Set<FDataminingcolumngroup> FDataminingcolumngroups) {
		this.schemeid = schemeid;
		this.FDatamininggroup = FDatamininggroup;
		this.FDataobject = FDataobject;
		this.FUser = FUser;
		this.orderno = orderno;
		this.iconcls = iconcls;
		this.title = title;
		this.subtitle = subtitle;
		this.maxcolumns = maxcolumns;
		this.isshare = isshare;
		this.isshareowner = isshareowner;
		this.othersetting = othersetting;
		this.remark = remark;
		this.creater = creater;
		this.createdate = createdate;
		this.lastmodifier = lastmodifier;
		this.lastmodifydate = lastmodifydate;
		this.FDataminingselectfields = FDataminingselectfields;
		this.FDataminingcolumngroups = FDataminingcolumngroups;
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Column(name = "schemeid", unique = true, nullable = false, length = 40)
	public String getSchemeid() {
		return this.schemeid;
	}

	public void setSchemeid(String schemeid) {
		this.schemeid = schemeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupid", nullable = false)
	public FDatamininggroup getFDatamininggroup() {
		return this.FDatamininggroup;
	}

	public void setFDatamininggroup(FDatamininggroup FDatamininggroup) {
		this.FDatamininggroup = FDatamininggroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "objectid", nullable = false)
	public FDataobject getFDataobject() {
		return this.FDataobject;
	}

	public void setFDataobject(FDataobject FDataobject) {
		this.FDataobject = FDataobject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public FUser getFUser() {
		return this.FUser;
	}

	public void setFUser(FUser FUser) {
		this.FUser = FUser;
	}

	@Column(name = "orderno")
	public Integer getOrderno() {
		return this.orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	@Column(name = "iconcls", length = 50)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "subtitle", length = 50)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name = "maxcolumns")
	public Integer getMaxcolumns() {
		return this.maxcolumns;
	}

	public void setMaxcolumns(Integer maxcolumns) {
		this.maxcolumns = maxcolumns;
	}

	@Column(name = "isshare")
	public Boolean getIsshare() {
		return this.isshare;
	}

	public void setIsshare(Boolean isshare) {
		this.isshare = isshare;
	}

	@Column(name = "isshareowner")
	public Boolean getIsshareowner() {
		return this.isshareowner;
	}

	public void setIsshareowner(Boolean isshareowner) {
		this.isshareowner = isshareowner;
	}

	@Column(name = "othersetting", length = 200)
	public String getOthersetting() {
		return this.othersetting;
	}

	public void setOthersetting(String othersetting) {
		this.othersetting = othersetting;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "FDataminingscheme")
	@OrderBy("orderno")
	public Set<FDataminingselectfield> getFDataminingselectfields() {
		return this.FDataminingselectfields;
	}

	public void setFDataminingselectfields(Set<FDataminingselectfield> FDataminingselectfields) {
		this.FDataminingselectfields = FDataminingselectfields;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "FDataminingscheme")
	@OrderBy("orderno")
	public Set<FDataminingcolumngroup> getFDataminingcolumngroups() {
		return this.FDataminingcolumngroups;
	}

	public void setFDataminingcolumngroups(Set<FDataminingcolumngroup> FDataminingcolumngroups) {
		this.FDataminingcolumngroups = FDataminingcolumngroups;
	}

}
