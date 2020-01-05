package com.bw.entity;

/**
 * @author zxy
 *
 * 2019年12月30日
 */
public class Goods {

	private Integer id;
	private String name;
	private String datea;
	private Integer tid;
	private Double price;
	private Integer status;
	private String tname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatea() {
		return datea;
	}
	public void setDatea(String datea) {
		this.datea = datea;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Goods(Integer id, String name, String datea, Integer tid, Double price, Integer status, String tname) {
		super();
		this.id = id;
		this.name = name;
		this.datea = datea;
		this.tid = tid;
		this.price = price;
		this.status = status;
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", datea=" + datea + ", tid=" + tid + ", price=" + price
				+ ", status=" + status + ", tname=" + tname + "]";
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
