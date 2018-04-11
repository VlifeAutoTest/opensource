package com.jhopesoft.business.sales.entity;
// default package
// Generated 2017-1-11 15:51:24 by Hibernate Tools 5.2.0.Beta1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

/**
 * SRate generated by hbm2java
 */
@Entity
@DynamicUpdate
@Table(name = "s_rate", catalog = "sales", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class SRate implements java.io.Serializable {


  private String rateid;
  private String name;
  private Set<SCustomer> SCustomers = new HashSet<SCustomer>(0);

  public SRate() {}


  public SRate(String rateid, String name) {
    this.rateid = rateid;
    this.name = name;
  }

  public SRate(String rateid, String name, Set<SCustomer> SCustomers) {
    this.rateid = rateid;
    this.name = name;
    this.SCustomers = SCustomers;
  }

  @Id


  @Column(name = "rateid", unique = true, nullable = false, length = 2)
  public String getRateid() {
    return this.rateid;
  }

  public void setRateid(String rateid) {
    this.rateid = rateid;
  }


  @Column(name = "name", unique = true, nullable = false, length = 50)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "SRate")
  public Set<SCustomer> getSCustomers() {
    return this.SCustomers;
  }

  public void setSCustomers(Set<SCustomer> SCustomers) {
    this.SCustomers = SCustomers;
  }



}

