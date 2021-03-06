package com.jhopesoft.framework.dao.entity.viewsetting;

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.jhopesoft.framework.dao.entity.system.FUser;

@Entity
@DynamicUpdate
@Table(name = "fov_userdefaultnavigatescheme")
public class FovUserdefaultnavigatescheme implements java.io.Serializable {

	private static final long serialVersionUID = 178642054546402068L;
	private String userdefaultid;
	private FUser FUser;
	private FovGridnavigatescheme fovGridnavigatescheme;

	public FovUserdefaultnavigatescheme() {
	}

	public FovUserdefaultnavigatescheme(String userdefaultid, FUser FUser,
			FovGridnavigatescheme fovGridnavigatescheme) {
		this.userdefaultid = userdefaultid;
		this.FUser = FUser;
		this.fovGridnavigatescheme = fovGridnavigatescheme;
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Column(name = "userdefaultid", unique = true, nullable = false, length = 40)
	public String getUserdefaultid() {
		return this.userdefaultid;
	}

	public void setUserdefaultid(String userdefaultid) {
		this.userdefaultid = userdefaultid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public FUser getFUser() {
		return this.FUser;
	}

	public void setFUser(FUser FUser) {
		this.FUser = FUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schemeid", nullable = false)
	public FovGridnavigatescheme getFovGridnavigatescheme() {
		return this.fovGridnavigatescheme;
	}

	public void setFovGridnavigatescheme(FovGridnavigatescheme fovGridnavigatescheme) {
		this.fovGridnavigatescheme = fovGridnavigatescheme;
	}

}
