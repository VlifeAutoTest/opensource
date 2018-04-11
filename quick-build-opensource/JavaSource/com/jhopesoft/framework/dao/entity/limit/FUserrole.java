package com.jhopesoft.framework.dao.entity.limit;

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
@Table(name = "f_userrole")
@SuppressWarnings("serial")

public class FUserrole implements java.io.Serializable {

	private String id;
	private FUser FUser;
	private FRole FRole;

	public FUserrole() {
	}

	public FUserrole(FUser FUser, FRole FRole) {
		this.FUser = FUser;
		this.FRole = FRole;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false, length = 40)

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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
	@JoinColumn(name = "roleid", nullable = false)

	public FRole getFRole() {
		return this.FRole;
	}

	public void setFRole(FRole FRole) {
		this.FRole = FRole;
	}

}