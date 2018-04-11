package com.jhopesoft.business.sales.entity;
// default package
// Generated 2017-1-11 15:51:24 by Hibernate Tools 5.2.0.Beta1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

/**
 * SProvince generated by hbm2java
 */
@Entity
@DynamicUpdate
@Table(name = "s_province", catalog = "sales", uniqueConstraints = {@UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "shortname")})
public class SProvince implements java.io.Serializable {


  private String provinceid;
  private SArea SArea;
  private String name;
  private String shortname;
  private Boolean isqu;
  private Boolean isshi;
  private Boolean isimportant;
  private String remark;
  private Set<SCity> SCities = new HashSet<SCity>(0);
  private Set<SProduct> SProducts = new HashSet<SProduct>(0);

  public SProvince() {}


  public SProvince(String provinceid, SArea SArea, String name, String shortname) {
    this.provinceid = provinceid;
    this.SArea = SArea;
    this.name = name;
    this.shortname = shortname;
  }

  public SProvince(String provinceid, SArea SArea, String name, String shortname, Boolean isqu, Boolean isshi,
      Boolean isimportant, String remark, Set<SCity> SCities, Set<SProduct> SProducts) {
    this.provinceid = provinceid;
    this.SArea = SArea;
    this.name = name;
    this.shortname = shortname;
    this.isqu = isqu;
    this.isshi = isshi;
    this.isimportant = isimportant;
    this.remark = remark;
    this.SCities = SCities;
    this.SProducts = SProducts;
  }

  @Id


  @Column(name = "provinceid", unique = true, nullable = false, length = 2)
  public String getProvinceid() {
    return this.provinceid;
  }

  public void setProvinceid(String provinceid) {
    this.provinceid = provinceid;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "areaid", nullable = false)
  public SArea getSArea() {
    return this.SArea;
  }

  public void setSArea(SArea SArea) {
    this.SArea = SArea;
  }


  @Column(name = "name", unique = true, nullable = false, length = 50)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Column(name = "shortname", unique = true, nullable = false, length = 10)
  public String getShortname() {
    return this.shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }


  @Column(name = "isqu")
  public Boolean getIsqu() {
    return this.isqu;
  }

  public void setIsqu(Boolean isqu) {
    this.isqu = isqu;
  }


  @Column(name = "isshi")
  public Boolean getIsshi() {
    return this.isshi;
  }

  public void setIsshi(Boolean isshi) {
    this.isshi = isshi;
  }


  @Column(name = "isimportant")
  public Boolean getIsimportant() {
    return this.isimportant;
  }

  public void setIsimportant(Boolean isimportant) {
    this.isimportant = isimportant;
  }


  @Column(name = "remark", length = 200)
  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "SProvince")
  public Set<SCity> getSCities() {
    return this.SCities;
  }

  public void setSCities(Set<SCity> SCities) {
    this.SCities = SCities;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "SProvince")
  public Set<SProduct> getSProducts() {
    return this.SProducts;
  }

  public void setSProducts(Set<SProduct> SProducts) {
    this.SProducts = SProducts;
  }



}

