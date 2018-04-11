package com.jhopesoft.business.sales.entity;
// default package
// Generated 2017-1-11 15:51:24 by Hibernate Tools 5.2.0.Beta1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

/**
 * SOrder generated by hbm2java
 */
@Entity
@DynamicUpdate
@Table(name = "s_order", catalog = "sales")
public class SOrder implements java.io.Serializable {


  private String orderid;
  private SCustomer SCustomer;
  private SSalesman SSalesman;
  private String name;
  private Date orderdate;
  private SCity SCityByFromcityid;
  private SCity SCityByTocityid;
  private Double amount;
  private Double alreadyamount;
  private Double arrearamount;
  private Double bl;
  private String creater;
  private Date createdate;
  private String lastmodifier;
  private Date lastmodifydate;
  private Set<SOrderdetail> SOrderdetails = new HashSet<SOrderdetail>(0);

  public SOrder() {}


  public SOrder(String orderid, SCustomer SCustomer, SSalesman SSalesman, String name, Date orderdate) {
    this.orderid = orderid;
    this.SCustomer = SCustomer;
    this.SSalesman = SSalesman;
    this.name = name;
    this.orderdate = orderdate;
  }

  public SOrder(String orderid, SCustomer SCustomer, SSalesman SSalesman, String name, Date orderdate,
      String fromcityid, String tocityid, Double amount, Double alreadyamount, Double arrearamount, String creater,
      Date createdate, String lastmodifier, Date lastmodifydate, Set<SOrderdetail> SOrderdetails) {
    this.orderid = orderid;
    this.SCustomer = SCustomer;
    this.SSalesman = SSalesman;
    this.name = name;
    this.orderdate = orderdate;
    this.amount = amount;
    this.alreadyamount = alreadyamount;
    this.arrearamount = arrearamount;
    this.creater = creater;
    this.createdate = createdate;
    this.lastmodifier = lastmodifier;
    this.lastmodifydate = lastmodifydate;
    this.SOrderdetails = SOrderdetails;
  }

  @Id


  @Column(name = "orderid", unique = true, nullable = false, length = 40)
  public String getOrderid() {
    return this.orderid;
  }

  public void setOrderid(String orderid) {
    this.orderid = orderid;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customerid", nullable = false)
  public SCustomer getSCustomer() {
    return this.SCustomer;
  }

  public void setSCustomer(SCustomer SCustomer) {
    this.SCustomer = SCustomer;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "salesmanid", nullable = false)
  public SSalesman getSSalesman() {
    return this.SSalesman;
  }

  public void setSSalesman(SSalesman SSalesman) {
    this.SSalesman = SSalesman;
  }


  @Column(name = "name", nullable = false, length = 40)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "orderdate", nullable = false, length = 10)
  public Date getOrderdate() {
    return this.orderdate;
  }

  public void setOrderdate(Date orderdate) {
    this.orderdate = orderdate;
  }


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fromcityid")
  public SCity getSCityByFromcityid() {
    return this.SCityByFromcityid;
  }

  public void setSCityByFromcityid(SCity SCityByFromcityid) {
    this.SCityByFromcityid = SCityByFromcityid;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tocityid")
  public SCity getSCityByTocityid() {
    return this.SCityByTocityid;
  }

  public void setSCityByTocityid(SCity SCityByTocityid) {
    this.SCityByTocityid = SCityByTocityid;
  }

  @Column(name = "amount", precision = 22, scale = 0)
  public Double getAmount() {
    return this.amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }


  @Column(name = "alreadyamount", precision = 22, scale = 0)
  public Double getAlreadyamount() {
    return this.alreadyamount;
  }

  public void setAlreadyamount(Double alreadyamount) {
    this.alreadyamount = alreadyamount;
  }


  @Column(name = "arrearamount", precision = 22, scale = 0)
  public Double getArrearamount() {
    return this.arrearamount;
  }

  public void setArrearamount(Double arrearamount) {
    this.arrearamount = arrearamount;
  }


  @Column(name = "creater", length = 40)
  public String getCreater() {
    return this.creater;
  }

  public void setCreater(String creater) {
    this.creater = creater;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "createdate", length = 19)
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "SOrder")
  public Set<SOrderdetail> getSOrderdetails() {
    return this.SOrderdetails;
  }

  public void setSOrderdetails(Set<SOrderdetail> SOrderdetails) {
    this.SOrderdetails = SOrderdetails;
  }


  public Double getBl() {
    return bl;
  }


  public void setBl(Double bl) {
    this.bl = bl;
  }



}

