package com.jhopesoft.framework.dao.entity.dictionary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@DynamicUpdate
@SuppressWarnings("serial")

@Table(name = "f_dictionarydetail", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "dictionaryid", "orderno" }),
		@UniqueConstraint(columnNames = { "dictionaryid", "vcode" }),
		@UniqueConstraint(columnNames = { "dictionaryid", "title" }) })
public class FDictionarydetail implements java.io.Serializable {

	public static final String ID = "ddetailid";
	public static final String CODE = "vcode";
	public static final String TITLE = "title";
	public static final String ORDERNO = "orderno";

	private String ddetailid;
	private FDictionary FDictionary;
	private String orderno;
	private String vcode;
	private String title;
	private String iconcls;
	private Boolean disabled;
	private String remark;

	public FDictionarydetail() {
	}

	public FDictionarydetail(com.jhopesoft.framework.dao.entity.dictionary.FDictionary fDictionary, String orderno,
			String vcode, String title) {
		super();
		FDictionary = fDictionary;
		this.orderno = orderno;
		this.vcode = vcode;
		this.title = title;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "ddetailid", unique = true, nullable = false, length = 40)
	public String getDdetailid() {
		return this.ddetailid;
	}

	public void setDdetailid(String ddetailid) {
		this.ddetailid = ddetailid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dictionaryid", nullable = false)
	public FDictionary getFDictionary() {
		return this.FDictionary;
	}

	public void setFDictionary(FDictionary FDictionary) {
		this.FDictionary = FDictionary;
	}

	@Column(name = "orderno", nullable = false, length = 10)
	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	@Column(name = "vcode", nullable = false, length = 50)
	public String getVcode() {
		return this.vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "iconcls", length = 50)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "disabled")
	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
